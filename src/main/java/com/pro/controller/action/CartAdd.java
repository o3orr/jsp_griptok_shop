package com.pro.controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.CartDAO;
import com.pro.dto.CartVO;
import com.pro.dto.UserVO;

public class CartAdd implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터로부터 상품의 ID를 가져옴
        int pid = Integer.parseInt(request.getParameter("pid"));
        UserVO user = (UserVO) request.getSession().getAttribute("loginUser");
        
        
        System.out.println("pid : " + pid);
        

        // CartDTO 객체 생성 및 설정
        CartVO vo = new CartVO();
        
        vo.setId(user.getId());
        vo.setPid(pid);
        
        System.out.println("vo : " + vo);

        
        // 장바구니에 상품 추가 DAO 호출
        CartDAO cartDAO = new CartDAO();
        cartDAO.addCartItem(vo);
        
        // 기존 장바구니 목록을 가져와서 새로 추가된 상품을 포함하여 다시 설정
        List<CartVO> cartList = cartDAO.selectAllCartList(user.getId());
        
        request.setAttribute("cartList", cartList);

        // 장바구니 페이지로 이동 또는 다른 동작 수행
        request.getRequestDispatcher("cart/cartView.jsp").forward(request, response);
    }
}
