package com.busanit501.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
// 화면상에서 접근하는 URL 주소를 맵핑 해주는 역할.
// 설정은 , 클래스 앞에도 가능하고, 메서드 앞에도 가능함.
@RequestMapping("/todo")
@Log4j2
public class TodoController {
  @RequestMapping("/list")
  public  void listTest() {
    // 최종 경로 : http://localhost:8080/todo/list
    // 최종 경로 : /todo/list
    log.info("todo list 조회 화면 테스트 콘솔");
  }
//  @RequestMapping(value = "/register", method = RequestMethod.GET)
  @GetMapping("/register")
  public void registerGetTest() {
    log.info("todo register 등록 화면 Get  테스트 콘솔");
  }

  @PostMapping("/register")
  public void registerPostTest() {
    log.info("todo register 등록 화면 Post 테스트 콘솔");
  }

  // 데이터 수집 방법들, 여러 예제 확인 해보기.
  // 파라미터 수집,
  // 기본, 데이터 포맷팅, 모델.
  // 결론, 스프링에서, 데이터 수집도 자동화를 이용하고,
  // 서버 측에서, 유효성 검사도 조금 더 쉽게 작업할 예정. 도구 사용해서.

  // 경로 확인. /todo/ex1
  // URL 쿼리 스트링온다.
  // 예) /todo/ex1?name="lsy"&age=30
  @GetMapping("/ex1")
  public void ex1Test(String name , int age ) {
    log.info("name : " + name + ", age : " + age);
  }

  // 기본값을 설정해보기.
  // @RequestParam, 클라이언트 보내는 정보에 대해서 수집관련 도구.
  @GetMapping("/ex2")
  public void ex2Test(@RequestParam(name = "name", defaultValue = "default lsy" ) String name , int age ) {
    log.info(" 기본값 name(이름 파라미터 안보내기) : " + name + ", age : " + age);
  }



}







