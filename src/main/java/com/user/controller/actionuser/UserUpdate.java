package com.user.controller.actionuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UserVO;

public class UserUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		UserVO vo = new UserVO();

		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		


		vo.setNum(loginUser.getNum());
		vo.setId(loginUser.getId());
		vo.setUsername(request.getParameter("username"));
		vo.setEmail(request.getParameter("email"));
		vo.setPass(request.getParameter("pass"));
		vo.setAddr(request.getParameter("addr"));
		vo.setAddr2(request.getParameter("addr2"));
		vo.setPhone(request.getParameter("phone"));

		UserDAO.getInstance().updateUser(vo);


		System.out.println("vo" + vo);

	
		request.getRequestDispatcher("user/mypage.jsp").forward(request, response);

	}

}
