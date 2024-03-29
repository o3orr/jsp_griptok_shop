package com.rv.controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.controller.action.Action;
import com.pro.dao.QnADAO;
import com.pro.dto.QnAVO;

public class QnAUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int qa_id = Integer.parseInt(request.getParameter("qa_id"));
        String id = request.getParameter("id");
        int pid = Integer.parseInt(request.getParameter("pid"));
        String question_title = request.getParameter("question_title");
        String question = request.getParameter("question");
        String answer = null;
        String state = request.getParameter("state");
        Timestamp created_at = new Timestamp(System.currentTimeMillis());

        QnAVO vo = new QnAVO();
        vo.setQa_id(qa_id);
        vo.setId(id);
        vo.setPid(pid);
        vo.setQuestion_title(question_title);
        vo.setQuestion(question);
        vo.setAnswer(answer);
        vo.setState(state);
        vo.setCreated_at(created_at);
        
        QnADAO.getInstance().updateQnA(vo);
        
        request.setAttribute("pid", vo.getPid());
        
        response.sendRedirect("ProServlet?command=pro_QnA_list&pid="+pid);

	}

}
