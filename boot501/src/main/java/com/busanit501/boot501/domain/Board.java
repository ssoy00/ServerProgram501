package com.busanit501.boot501.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 이클래스는 실제 데이터베이스에 영향이 있다.
// 반드시, pk 있어야 함.
@Entity
public class Board {

  // pk, = not null, primary key
  @Id
  // pk 숫자를 자동 증가를 어떤 방식으로 하겠니? 해당 마리아 디비에서 사용하는 증가 번호 정책을 이용하겠습니다.
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long bno;
  private String title;
  private String content;
  private String writer;
  // 등록시간,
  // 수정시간, 많은 테이블에서 공통적으로 사용하니, 인터페이스로 분리해서 재사용할 예정.


}







