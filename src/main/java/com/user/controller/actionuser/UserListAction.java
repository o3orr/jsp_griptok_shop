package com.user.controller.actionuser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UserVO;

public class UserListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "/user/userList.jsp";
		
		UserDAO dao = UserDAO.getInstance();
		List<UserVO> list = dao.listUser();
		
		request.setAttribute("userlist", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
