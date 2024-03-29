package com.pro.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.CartDAO;
import com.pro.dao.ProDAO;
import com.pro.dto.CartVO;
import com.pro.dto.ProVO;
import com.pro.dto.UserVO;

public class CartListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id"); //아이디값가져옴
		System.out.println("id>>" + id);
		System.out.println("테스트");
		String url = "cart/CartList.jsp";

		CartDAO ODao = CartDAO.getInstance();
		List<CartVO> list = ODao.selectAllCartList(id); //아이디에 맞는 장바구니값가져옴
		
		List<Integer>Ilist = ODao.selectCartListPid(id); //아이데 맞는 장바구니 상품고유키가져옴
		
		System.out.println(Ilist);
		
		ProDAO pDao = ProDAO.getInstance();
		
		List<ProVO>plist =pDao.selectProName(Ilist); //상품고유키에맞는 상품명가져옴
		
		
		
		System.out.println("plist>>" + plist);
		
		System.out.println("list >>" + list);
		
		
        int pid = Integer.parseInt(request.getParameter("pid")); //선택한 상품pid값가져옴 
        UserVO user = (UserVO) request.getSession().getAttribute("loginUser");
        
        
        System.out.println("pid : " + pid);
        

        // CartDTO 객체 생성 및 설정
        CartVO vo = new CartVO();
        
        vo.setId(id);
        vo.setPid(pid);
        
        System.out.println("vo테스트임 : " + vo);

        
        // 장바구니에 상품 추가 DAO 호출
        CartDAO cartDAO = new CartDAO();
        cartDAO.addCartItem(vo);
        
        // 기존 장바구니 목록을 가져와서 새로 추가된 상품을 포함하여 다시 설정
        List<CartVO> cartList = cartDAO.selectAllCartList(id);
        
        request.setAttribute("product", plist);
		request.setAttribute("CartList", list);
		request.setAttribute("id", id);
        
        request.setAttribute("cartList", cartList);

		request.getRequestDispatcher(url).forward(request, response);
	}

}