package com.busanit501.samplejsp501.connectTest;

import com.busanit501.samplejsp501.todo.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDAOTest {

  //디비 연결하고, 기능 테스트.
  // 다른 클래스의 인스턴스가 필요해요.
  // 사용하기위해서 방법? 주입, 포함
  // 선언만 했음. 여기 null (집주소가 없네. 0x100)
  private TodoDAO todoDAO;

  // 각 단위 테스트가 실행되기전에,, 먼저 실행되는 어노테이션,
  // todoDAO 할당 함.
  @BeforeEach
  public void ready() {
    todoDAO = new TodoDAO();
  }

  @Test
  public void getTimeTest() throws Exception {

    // todoDAO.getTime() 이기능 확인. 단위테스트.
    // String time = todoDAO.getTime();
    String time = todoDAO.getTime2();
    System.out.println("time : " + time);
  }



}







