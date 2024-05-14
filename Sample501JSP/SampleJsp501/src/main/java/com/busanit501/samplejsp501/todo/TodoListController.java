package com.busanit501.samplejsp501.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 목록 화면으로 전달,
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/list.jsp");
    requestDispatcher.forward(req, resp);
  }
}







