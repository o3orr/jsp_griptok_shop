package com.pro.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPay1FormAction implements Action {

	/*
	  @Override
	 
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String[] selectedOrderIds = request.getParameterValues("selectedOrders");
	    String id = request.getParameter("id");
	    
	    
	    
	    // 선택된 상품 번호와 이름을 리스트에 추가
	    List<String> selectedOrderList = new ArrayList<>();
	    if (selectedOrderIds != null) {
	        for (String cart_id : selectedOrderIds) {
	            selectedOrderList.add(cart_id);
	        }
	    }
	    // 선택된 상품 번호와 이름을 request attribute로 설정하여 JSP로 전달
	    request.setAttribute("selectedOrderIds", selectedOrderList);
	    request.setAttribute("id", id);
	    
	    // JSP 페이지로 포워딩
	    request.getRequestDispatcher("cart/OrderPay1.jsp").forward(request, response);
	}
	*/
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String[] selectedOrderIds = request.getParameterValues("selectedOrders");
	    String pid = request.getParameter("pid");
	    
	    // 선택된 상품 번호를 리스트에 추가
	    List<String> selectedOrderList = new ArrayList<>();
	    if (selectedOrderIds != null) {
	        for (String orderId : selectedOrderIds) {
	            selectedOrderList.add(orderId);
	        }
	    }
	    // 선택된 상품 번호와 상품 ID를 request attribute로 설정하여 JSP로 전달
	    request.setAttribute("selectedOrderIds", selectedOrderList);
	    request.setAttribute("pid", pid);
	    
	    // JSP 페이지로 포워딩
	    request.getRequestDispatcher("cart/OrderPay1.jsp").forward(request, response);
	}


}
