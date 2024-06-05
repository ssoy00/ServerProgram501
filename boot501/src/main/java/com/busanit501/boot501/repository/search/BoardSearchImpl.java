package com.busanit501.boot501.repository.search;

import com.busanit501.boot501.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

// Querydsl 사용하기 위한 조건
// 인터페이스 이름 + Impl
// 상속 : QuerydslRepositorySupport,
// BoardSearch 구현을 해야합니다.
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

  public BoardSearchImpl() {
    super(Board.class);
  }

  @Override
  public Page<Board> search(Pageable pageable) {
    return null;
  }
}







