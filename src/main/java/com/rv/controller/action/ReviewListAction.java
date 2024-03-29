package com.rv.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.ReviewDAO;
import com.pro.dto.ReviewVO;

public class ReviewListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			List<ReviewVO> list = ReviewDAO.getInstance().selectAllReviewByPid(pid);
			request.setAttribute("ReviewList", list);
			
			request.getRequestDispatcher("review/reviewList.jsp").forward(request, response);
		
	}

}
