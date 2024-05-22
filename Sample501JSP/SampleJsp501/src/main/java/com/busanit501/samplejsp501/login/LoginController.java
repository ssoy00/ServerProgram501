package com.busanit501.samplejsp501.login;

import com.busanit501.samplejsp501.todo.dto.MemberDTO;
import com.busanit501.samplejsp501.todo.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그인 입력폼으로 전달.
    System.out.println("get 으로 login 처리");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/login.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 세션의 정보를 설정, setter
    // 화면에서, 아이디, 패스워드를 먼저 받기.
    String mid = req.getParameter("mid");
    String mpw = req.getParameter("mpw");

    // 디비에서 아이디,패스워드를 가져와서 비교.
    try{
      MemberDTO memberDTO = MemberService.INSTANCE.getOneMember(mid, mpw);
      HttpSession session = req.getSession();
      //세션의 정보를 저장.
      session.setAttribute("loginInfo",memberDTO);
      resp.sendRedirect("/todo/list");
    } catch (Exception e) {
      // 만약에 예외가 발생했다면, todo/list 보내면서, 쿼리스트링으로
      // 파라미터로 error 전달.
      resp.sendRedirect("/todo/login?result=error");
    }





  }
}







