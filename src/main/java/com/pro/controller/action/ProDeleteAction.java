package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.ProDAO;
import com.pro.dto.ProVO;

public class ProDeleteAction implements Action {

	 @Override
	    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	        int pid = Integer.parseInt(request.getParameter("pid"));
	        
	        // 상품 삭제 전 유효성 검사
	        ProDAO.getInstance().deletePro(pid);
	        
	        response.sendRedirect("ProServlet?command=pro_list");
	    }

}
