package com.busanit501.springex.dto;

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
}







