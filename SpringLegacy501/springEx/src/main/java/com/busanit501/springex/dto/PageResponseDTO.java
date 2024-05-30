package com.busanit501.springex.dto;

import lombok.Builder;

import java.util.List;

// <E>, 포괄적인 표현
// 예) PageResponseDTO<TodoDTO>
// 예) PageResponseDTO<SearchDTO>
// 예) PageResponseDTO<MemberDTO>
public class PageResponseDTO<E> {
  private int page;
  private int size;
  private int total;

  //시작 페이지 번호,
  private int start;

  //끝 페이지 번호,
  private int end;

  // 이전 페이지 존재 여부
  private boolean prev;

  // 다음 페이지 존재 여부
  private boolean next;

  // 전달할 페이징이 된 todo 10개 목록.
  private List<E> dtoList;

  //생성자 만들기.
  // builderMethodName = "withAll" -> 기존 빌더 패턴 사용시, TodoVO.builder.build()
  // builder 의 이름이 -> withAll 교체
  // pageRequestDTO : 화면 -> 서버 : 페이징 정보, page, size, getSkip,
  // List<E> dtoList : 10개씩 조회한 Todo 정보들
  // total : Todo의 전체 갯수
  // 결론, PageResponseDTO 에, 파라미터의 정보들이 다 들어있다.
  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();

    this.total = total;
    this.dtoList = dtoList;
  }

}







