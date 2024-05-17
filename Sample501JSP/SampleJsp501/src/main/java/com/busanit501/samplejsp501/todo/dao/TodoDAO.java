package com.busanit501.samplejsp501.todo.dao;

public class TodoDAO {
  // 데이터베이스 직접적인 비지니스 로직 처리하는 기능을 만들기.
  // 샘플
  // 현재 시간을 가져오는 기능.
  public String getTime() {
    // HikariCP 이용해서, 디비 연결하는 도구 Connection  타입의 인스턴스 만들기.
    // 사용법.
//    Connection conn = ConnectionUtil.INSTANCE.getConnection();
    // 디비에 접근 하려면, 반드시 예외 처리를 해야함.
    // 3가지 방법. 1) try catch finally 2) throws 3) try resources with (자동 close)
    // 결론, 롬복의 @cleanup , 자동으로 반납함.

    return "테스트 조금 있다 변경함. 현재시각으로";
  }
}






