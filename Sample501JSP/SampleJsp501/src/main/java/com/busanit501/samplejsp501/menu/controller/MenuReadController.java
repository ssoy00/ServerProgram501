package com.busanit501.samplejsp501.menu.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "menuRead", urlPatterns = "/menu/read")
public class MenuReadController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //화면이동 1,

    req.getRequestDispatcher("/WEB-INF/menu/menuRead.jsp")
        .forward(req, resp);
  }
}







