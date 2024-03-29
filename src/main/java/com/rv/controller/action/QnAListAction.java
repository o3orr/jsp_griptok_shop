package com.rv.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.QnADAO;
import com.pro.dao.ReviewDAO;
import com.pro.dto.QnAVO;
import com.pro.dto.ReviewVO;

public class QnAListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));
		
		List<QnAVO> list = QnADAO.getInstance().selectAllQnAByPid(pid);
		request.setAttribute("pid", pid);
		request.setAttribute("QnAList", list);
		
		
		request.getRequestDispatcher("review/QnAList.jsp").forward(request, response);
		
	}

}
