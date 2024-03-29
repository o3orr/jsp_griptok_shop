package com.user.controller.actionuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UserVO;

public class MypageForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");

		UserVO vo = new UserVO();

		vo = UserDAO.getInstance().selectOnUser(id);

		request.setAttribute("loginUser", vo);
		
		request.getRequestDispatcher("user/mypage.jsp").forward(request, response);

	}

}
