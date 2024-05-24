package com.busanit501.samplejsp501.menu.controller.menuMember;

import com.busanit501.samplejsp501.menu.dto.MenuMemberDTO;
import com.busanit501.samplejsp501.menu.service.MenuMemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "menuLoginController", urlPatterns = "/menuLogin")
public class MenuLoginController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 로그인 입력폼으로 전달.
    System.out.println("get 으로 login 처리");
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/login.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 세션의 정보를 설정, setter
    // 화면에서, 아이디, 패스워드를 먼저 받기.
    String mid = req.getParameter("mid");
    String mpw = req.getParameter("mpw");

    // 디비에서 화면에서 받은 ID, PW  있는지 확인.
    try {
      MenuMemberDTO menuMemberDTO = MenuMemberService.INSTANCE.getOneMember(mid,mpw);
      // 자동로그인 체크를 안했을 경우. 로직.
      HttpSession session = req.getSession();
      //세션의 정보를 저장.
      // memberDTO 여기에 어떤 정보가 있나요? mid, mpw, mname, uuid(없음.)
      session.setAttribute("loginInfo", menuMemberDTO);
      resp.sendRedirect("/menu/list");
    } catch (Exception e) {
      resp.sendRedirect("/menuLogin?result=error");
    }




  }// doPost 닫는 부분
} // class 닫는 부분









