package com.rv.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.QnADAO;
import com.pro.dto.QnAVO;

public class QnAWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		QnAVO vo = QnADAO.getInstance().selectQnAByPid(pid);
		request.setAttribute("pid", vo.getPid());
		
		request.getRequestDispatcher("review/QnAWriteForm.jsp").forward(request, response);

	}

}
