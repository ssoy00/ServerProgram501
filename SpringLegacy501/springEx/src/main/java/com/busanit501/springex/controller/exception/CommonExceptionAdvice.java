package com.busanit501.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

  // REST API , RestController, 화면없이 데이터만 전달시
  // ResponseBody, http 전달시, 헤더와 바디(데이터)
  // 결론, 데이터만 전달 하기.
  @ResponseBody
  // 예외가 발생했을 경우 처리할 클래스를 지금은 구체적으로 작성하지만,
  // 일반적으로, 상위 개념인 Exception으로 처리할 예정.
  @ExceptionHandler(NumberFormatException.class)
  public String exceptNumberFormat(NumberFormatException numberFormatException) {

    log.error("----------error----------------");
    log.error("numberFormatException.getMessage() : " + numberFormatException.getMessage());
    return "숫자 포맷이 아닌 문자열이 넘어와서 에러가 남 테스트.";

  }

}







