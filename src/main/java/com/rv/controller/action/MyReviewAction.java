package com.rv.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.ReviewDAO;
import com.pro.dto.ReviewVO;

public class MyReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		List<ReviewVO> list = ReviewDAO.getInstance().selectAllReviewByUserid(id);
		request.setAttribute("MyReviewList", list);
		
		request.getRequestDispatcher("review/myReviewList.jsp").forward(request, response);

	}

}
