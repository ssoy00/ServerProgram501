package com.busanit501.samplejsp501.todo.controller;

import com.busanit501.samplejsp501.todo.dto.TodoDTO;
import com.busanit501.samplejsp501.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

  //주입 , 서비스 인스턴스 , 포함.
  private TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   // DB 에서 , 전체 목록을 가져오기.

    List<TodoDTO> sampleList = null;
    try {
      sampleList = TodoService.INSTANCE.listAll();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    req.setAttribute("list",sampleList);

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
    requestDispatcher.forward(req, resp);
  }
}







