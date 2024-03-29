package com.pro.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.pro.dao.ProDAO;
import com.pro.dto.ProVO;

public class ProListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "pro/proList.jsp";
		
		ProDAO dao = ProDAO.getInstance();
		List<ProVO> list = dao.selectAllPro();
	
		request.setAttribute("proList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
