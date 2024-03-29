package com.pro.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pro.controller.action.Action;
import com.pro.controller.action.ActionFactory;
import com.pro.dao.ProDAO;
import com.pro.dto.ProVO;

@WebServlet("/ProServlet")
public class ProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET 요청에 대한 처리
		String command = request.getParameter("command");

		System.out.println("command" + command);
		ActionFactory af = ActionFactory.getInstance();

		
		
		Action action = af.getAction(command);

		if (action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String savePath = "upload";
		ServletContext context = getServletContext();
		String path = context.getRealPath(savePath);
		System.out.println("저장경로 : " + path);

		String encType = "utf-8";
		int sizeLimit = 20 * 1024 * 1024; // 최대 20MB 전송

		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		String command = multi.getParameter("command");

	//System.out.println("ProServlet(post) command : " + command);
		
		if(command.equals("pro_write")) {
			String pname = multi.getParameter("pname");
			String content = multi.getParameter("content");
			int price = Integer.parseInt(multi.getParameter("price"));
			int stock = Integer.parseInt(multi.getParameter("stock"));
			String img = multi.getFilesystemName("img");

			// 이미지가 전송되지 않은 경우 기존 이미지 사용
			if (img == null) {
				img = multi.getParameter("nonmakeImg");
			}

			ProVO vo = new ProVO();

			vo.setPname(pname);
			vo.setContent(content);
			vo.setPrice(price);
			vo.setStock(stock);
			vo.setImg(img);

			ProDAO dao = ProDAO.getInstance();
			dao.insertPro(vo); // 저장
		}else if (command.equals("pro_update")) {
		    int pid = Integer.parseInt(multi.getParameter("pid"));
		    String pname = multi.getParameter("pname");
		    String content = multi.getParameter("content");
		    int price = Integer.parseInt(multi.getParameter("price"));
		    int stock = Integer.parseInt(multi.getParameter("stock"));
		    String img = multi.getFilesystemName("img");
		    
		    // 이미지가 선택되지 않은 경우
		    if (img == null) {
		        img = multi.getParameter("nonmakeImg"); // 기존 이미지 유지
		    } else {
		        img = multi.getOriginalFileName("img"); // 새로운 이미지로 대체
		    }
		    
		    ProVO vo = new ProVO();
		    vo.setPid(pid);
		    vo.setPname(pname);
		    vo.setContent(content);
		    vo.setPrice(price);
		    vo.setStock(stock);
		    vo.setImg(img);

		    ProDAO dao = ProDAO.getInstance();
		    dao.updatePro(vo);
		}

		response.sendRedirect("ProServlet?command=pro_list");
		
	}
}