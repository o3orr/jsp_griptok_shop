package com.rv.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.QnADAO;
import com.pro.dto.QnAVO;

public class QnAUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));
		int qa_id = Integer.parseInt(request.getParameter("qa_id"));
		QnAVO vo = QnADAO.getInstance().selectQnAByPidQaId(pid, qa_id);
		request.setAttribute("QnA", vo);
		
		request.getRequestDispatcher("review/QnAUpdateForm.jsp").forward(request, response);

	}

}
