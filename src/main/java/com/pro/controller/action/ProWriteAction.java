package com.pro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProWriteAction implements Action {

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 이미지 업로드는 서블릿에서 처리하므로 여기에서는 필요 없음
        // 이미지 업로드 시에는 "pro_write" command를 받아야함

        // 다른 필요한 처리 로직 작성 가능

        // 상품 등록 완료 후에는 다시 상품 목록 페이지로 리다이렉트
        response.sendRedirect("ProServlet?command=pro_list");
    }
}
