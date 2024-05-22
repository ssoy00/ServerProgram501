package com.busanit501.samplejsp501.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    // 기본 설정,
    // 동작 여부 확인.
    log.info("로그인 필터 동작 여부 확인. ");
    filterChain.doFilter(servletRequest,servletResponse);
  }
}







