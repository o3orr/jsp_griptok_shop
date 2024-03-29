package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.ProDAO;
import com.pro.dto.ProVO;

public class ProUpdateFormAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "pro/proUpdate.jsp";
        
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        ProDAO dao = ProDAO.getInstance();
        
        ProVO vo = dao.selectProByPid(pid);
        
        request.setAttribute("pro", vo);
        
        request.getRequestDispatcher(url).forward(request, response);
    }
}
