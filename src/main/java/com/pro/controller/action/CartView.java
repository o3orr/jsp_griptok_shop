package com.pro.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.CartDAO;
import com.pro.dto.CartVO;
import com.pro.dto.UserVO; // UserVO를 import 추가

public class CartView implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 사용자 정보(UserVO)를 가져옴
        UserVO user = (UserVO) request.getSession().getAttribute("loginUser");

        if (user != null) { // 사용자 정보가 null이 아닌 경우
            String id = user.getId(); // 사용자 ID를 가져옴

            // 장바구니에 담긴 상품 목록을 가져옴
            CartDAO cartDAO = new CartDAO();
            List<CartVO> cartList = cartDAO.selectAllCartList(id);

            // 가져온 상품 목록을 request에 저장
            request.setAttribute("cartList", cartList);

            // 장바구니 페이지로 포워딩
            request.getRequestDispatcher("cart/cartView.jsp").forward(request, response);
        } else { // 사용자 정보가 null인 경우
            // 로그인 페이지로 리다이렉트 또는 다른 처리
            response.sendRedirect("login.jsp"); // 예시로 로그인 페이지로 리다이렉트
        }
    }

}
