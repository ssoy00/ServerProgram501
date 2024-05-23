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
import java.util.UUID;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

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

    // 자동 로그인 체크 여부를 값을 가져오기.
    String auto = req.getParameter("auto");
    // 상태 변수, 자동 로기은 체크 여부
    boolean rememberMe = auto != null && auto.equals("on");

    // rememberMe , 체크가 되었다면, UUID를 생성함.
    // UUID 자동 랜덤한 문자열을 생성해줌. 중복을 피하는 용도로 사용함.

    try {
      // mid, mpw, 해당 유저가 있다면, 회원 정보 가져오기, Todo 상세보기와 같음.
      // 아직, uuid 가 없음.
      MemberDTO memberDTO = MemberService.INSTANCE.getOneMember(mid, mpw);

      // 자동로그인 여부가 체크가 되었다면.
      if (rememberMe) {
        // 랜덤한 문자열을 생성.
        String uuid = UUID.randomUUID().toString();
        // 랜덤한 문자열을 , 위에서 받아온 정보에, uuid 업데이트하기. memberDTO
        // 디비에 데이터를 업데이트 하는 부분,
        MemberService.INSTANCE.updateUUID(mid, uuid);
        // 임시 모델에, 같은 uuid 담는 코드.
        memberDTO.setUuid(uuid);

        // 세션의 설정하기 위한 도구를 가지고 오고,
        // 세터, 게터
        HttpSession session = req.getSession();
        //세션의 정보를 저장.
        // memberDTO 여기에 어떤 정보가 있나요? mid, mpw, mname, uuid(방금추가됨)
        session.setAttribute("loginInfo", memberDTO);
        resp.sendRedirect("/todo/list");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }// doPost 닫는 부분
} // class 닫는 부분









