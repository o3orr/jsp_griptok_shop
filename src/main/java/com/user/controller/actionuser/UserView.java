package com.user.controller.actionuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UserVO;

public class UserView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));

		UserVO vo = new UserVO();

		vo = UserDAO.getInstance().selectUser(num);

		request.setAttribute("user", vo);

		request.getRequestDispatcher("user/userView.jsp").forward(request, response);

	}

}
