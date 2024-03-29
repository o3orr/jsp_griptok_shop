package com.pro.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.CartDAO;

public class OrderDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] selectedOrderIds = request.getParameterValues("selectedOrders");

		System.out.println("selectedOrderIds" + selectedOrderIds);
		String id = request.getParameter("id");
		
		System.out.println("삭제할 번호" + selectedOrderIds[0]);
		List<String> selectedOrderList = new ArrayList<>();
		if (selectedOrderIds != null) {
			for (String cart_id : selectedOrderIds) {
				selectedOrderList.add(cart_id);
			}
		}
		CartDAO.getInstance().deleteSelectedOrders(selectedOrderList, id);

//		response.sendRedirect("CartServlet?command=cart_list&id="+id);
		request.getRequestDispatcher("UserServlet?command=cart_list&id="+id).forward(request, response);
	}
}