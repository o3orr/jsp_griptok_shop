package com.user.controller.actionuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UserVO;

public class UserLogin implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        
        UserDAO dao = UserDAO.getInstance();
        
        String is_admin = request.getParameter("is_admin");
		// 사용자 로그인 정보 확인
        int loginResult = dao.userCheck(id, pass, is_admin );
                
        HttpSession session = request.getSession();
        
        System.out.println("로그인" + loginResult);
        if(loginResult == 1) {
            UserVO vo = dao.selectOnUser(id);
            session.setAttribute("loginUser", vo);
            System.out.println("vo>>" + vo);
            
            
			/*
			 * if(vo.getIs_admin().equals("Y")) { // 관리자인 경우 // 관리자 페이지로 이동 String url =
			 * "pro/proList.jsp"; response.sendRedirect(url); } else { // 일반 사용자인 경우 // 상품
			 * 목록 페이지로 이동 String url = "pro/proList.jsp"; response.sendRedirect(url); }
			 */
            response.sendRedirect("ProServlet?command=pro_list");
            
        } else if(loginResult == 0) {
            request.setAttribute("message", "존재하지 않는 회원입니다.");
            RequestDispatcher dis = request.getRequestDispatcher("user/userLogin.jsp");
            dis.forward(request, response);
        } else if(loginResult == -1) {
            request.setAttribute("message", "비밀번호가 맞지 않습니다.");
            RequestDispatcher dis = request.getRequestDispatcher("user/userLogin.jsp");
            dis.forward(request, response);
        } else if(loginResult == 2) {
        	UserVO vo = dao.selectOnUser(id);
        	session.setAttribute("loginUser", vo);
            
            response.sendRedirect("ProServlet?command=pro_list");
        }
    }
}
