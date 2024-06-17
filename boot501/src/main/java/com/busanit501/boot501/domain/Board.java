package com.busanit501.boot501.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 이클래스는 실제 데이터베이스에 영향이 있다.
// 반드시, pk 있어야 함.
@Entity
public class Board extends BaseEntity{

  // pk, = not null, primary key
  @Id
  // pk 숫자를 자동 증가를 어떤 방식으로 하겠니? 해당 마리아 디비에서 사용하는 증가 번호 정책을 이용하겠습니다.
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long bno;

  @Column(length = 500,nullable = false)
  private String title;

  @Column(length = 2000, nullable = false)
  private String content;

  @Column(length = 50, nullable = false)
  private String writer;
  // 등록시간,
  // 수정시간, 많은 테이블에서 공통적으로 사용하니, 인터페이스로 분리해서 재사용할 예정.

  // 게시글 1, 이미지들 N , 연관관계 추가.
  // 게시글 입장에서, 멤버에, 이미지들 목록 요소를 가지고 있어요.
  // 예) 1번 게시글에 이미지들 3장 업로드가되었다.
  // 기본 , 양방향이면, 중간 테이블을 만들어줌. 기본값.
  // mappedBy 설정을 하면, 중간 테이블을 생성 안하고 작업 가능.
  // 자식 테이블 : BoardImage 에 보면,
//  @ManyToOne
//  private Board board; 해당 참조형 변수명을 사용함.
  @OneToMany(mappedBy = "board")
  @Builder.Default
  private Set<BoardImage> imageSet = new HashSet<>();

  public void changeTitleAndContent(String title, String content) {
    this.title = title;
    this.content = content;
  }

}







