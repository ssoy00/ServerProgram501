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
      Long tno = Long.valueOf(req.getParameter("tno"));
      TodoDTO sample = todoService.getSelectOne(tno);
      log.info("TodoListController , 확인2, sample : " + sample);
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
    resp.sendRedirect("/todo/list");
  }
}







