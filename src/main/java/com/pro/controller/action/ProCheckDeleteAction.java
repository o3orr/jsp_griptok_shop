package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.dao.ProDAO;
import com.pro.dto.ProVO;

public class ProCheckDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String pid = request.getParameter("pid");
        String url = null;
        
        try {
            // 상품 조회
            ProVO vo = ProDAO.getInstance().selectProByPid(Integer.parseInt(pid));
            System.out.println("상품 조회 결과: " + vo); // 상품 정보 출력
            System.out.println("입력된 상품 번호: " + pid); // 입력된 상품 번호 출력
            
            // 비교할 때는 int 타입으로 비교
            if (vo.getPid() == Integer.parseInt(pid)) {
                // 상품이 존재하는 경우
                url = "/pro/checkSuccess.jsp";
            } else {
                // 상품이 존재하지 않는 경우
                url = "/pro/proDeleteCheck.jsp";
                request.setAttribute("message", "상품이 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            // 상품 ID가 잘못된 형식이거나 null인 경우
            url = "/pro/proDeleteCheck.jsp";
            request.setAttribute("message", "상품 ID가 올바르지 않습니다.");
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
