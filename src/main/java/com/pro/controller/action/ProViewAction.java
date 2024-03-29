package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.ProDAO;
import com.pro.dto.ProVO;

public class ProViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProVO vo = ProDAO.getInstance().selectProByPid(pid);
		
		
		request.setAttribute("pro", vo);
		
		String url = "pro/proView.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
		

	}

}
