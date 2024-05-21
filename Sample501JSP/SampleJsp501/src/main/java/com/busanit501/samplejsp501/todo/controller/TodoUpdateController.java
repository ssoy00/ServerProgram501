package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "todoUpdate",urlPatterns = "/todo/update")
public class TodoUpdateController extends HttpServlet {
  private TodoService todoService = TodoService.INSTANCE;
  // 폼, 처리도

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      // 수정폼, 해당 게시글 번호에 대해서 수정폼을 열기.
      Long tno = Long.valueOf(req.getParameter("tno"));
      // tno 번호에 대한 해당 게시글 가져오기.
      TodoDTO sample = todoService.getSelectOne(tno);
      //
      log.info("TodoListController , 확인2, sample : " + sample);
      // 화면에 전달하기. key : sample , 값 : 0x100
      req.setAttribute("sample", sample);
      req.getRequestDispatcher("/WEB-INF/todo/todoUpd.jsp")
          .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //처리
    // 수정, 변경할 데이터를 먼저 가져오기. 콘솔에 찍어보기.
    Long tno = Long.valueOf(req.getParameter("tno"));
    log.info("tno: 수정작업중, 데이터받아서 확인중.1 tno : " + tno);
    String title = req.getParameter("title");
    log.info("tno: 수정작업중, 데이터받아서 확인중.1 title: " + title);

    resp.sendRedirect("/todo/list");
  }
}







