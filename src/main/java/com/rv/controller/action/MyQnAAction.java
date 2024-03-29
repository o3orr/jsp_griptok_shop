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

public class MyQnAAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		List<QnAVO> list = QnADAO.getInstance().selectAllQnAByUserid(id);
		request.setAttribute("MyQnAList", list);
		
		request.getRequestDispatcher("review/myQnAList.jsp").forward(request, response);

	}

}
