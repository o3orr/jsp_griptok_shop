package com.user.controller.actionuser;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.UserDAO;
import com.pro.dto.UserVO;

public class RegisterAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        UserVO vo = new UserVO();

        vo.setId(request.getParameter("id"));
        vo.setUsername(request.getParameter("username"));
        vo.setEmail(request.getParameter("email"));
        vo.setPass(request.getParameter("pass"));
        vo.setAddr(request.getParameter("postcode"));// 우편번호를 ADDR에 저장
        vo.setAddr2(request.getParameter("addr2"));
        vo.setPhone(request.getParameter("phone"));


        // 가입일 변환
        String registerDateString = request.getParameter("register_date");
        if (registerDateString != null && !registerDateString.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp registerDate = null;
            try {
                Date parsedDate = dateFormat.parse(registerDateString);
                registerDate = new Timestamp(parsedDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                // 예외 처리를 수행할 수 있습니다.
            }
            vo.setRegistration_date(registerDate);
        }

        // 관리자 여부 변환
        String isAdminString = request.getParameter("is_admin");
        int isAdmin = isAdminString != null && (isAdminString.equalsIgnoreCase("Y") || isAdminString.equalsIgnoreCase("yes")) ? 1 : 0;
        vo.setIs_admin(isAdminString);

        UserDAO.getInstance().insertUser(vo);

        response.sendRedirect("ProServlet?command=pro_list");
    }
}