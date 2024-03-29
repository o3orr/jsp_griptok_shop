package com.pro.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.dto.OrderVO;
import com.pro.dto.UserVO;

public class OrderPay1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] selectedOrderIds = request.getParameterValues("selectedOrders");

		String id = request.getParameter("id");  //사용자 식별
		
		System.out.println("구매할 번호" + selectedOrderIds);
		List<String> selectedOrderList = new ArrayList<>();
		if (selectedOrderIds != null) {  
			for (String cart_id : selectedOrderIds) {
				selectedOrderList.add(cart_id);
			}
		}
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		List<OrderVO> ovo = getOrder(request);
		
//		int totalPrice = calculateTotalPrice(order);
		
//		 System.out.println("User: " + loginUser);
//	        System.out.println("Total Price: " + totalPrice);
//	        System.out.println("Order Details: " + order);
	
	}

	private List<OrderVO> getOrder(HttpServletRequest request) {
		List<OrderVO> order = new ArrayList<>();
		return order;
	}
	
//	private int calculateTotalPrice(List<OrderVO> order) {
//		int totalPrice = 0;
//		
//		for(OrderVO detail : order) {
//			totalPrice += detail.getPrice() * detail.get 
//		}
//	}
	
	

}
// 구매할 번호로 orderDAO에서 order테이블에 구매내역 넣는 update메서드 작성
// 구매하면 products에서 상품수량이 하나 빠짐

//			UsersVO vo = OrderDAO.getInstance().selectOrderByNum(num);

//		request.setAttribute("order", vo);

//
//		request.getRequestDispatcher(url).forward(request, response);