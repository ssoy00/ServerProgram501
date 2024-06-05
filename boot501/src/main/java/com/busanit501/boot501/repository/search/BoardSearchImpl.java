package com.busanit501.boot501.repository.search;

import com.busanit501.boot501.domain.Board;
import com.busanit501.boot501.domain.QBoard;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

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
    // Querydsl 이용하는 기본 문법
    QBoard board = QBoard.board;
    // select from board 하는 것과 비슷한 기능.
    // query -> sql 관련 문장을, 자바 문법으로 표현하고 있다.
    JPQLQuery<Board> query = from(board);
    // where 조건절  where title like
    query.where(board.title.contains("1"));

    // 페이징 처리 적용하기.
    this.getQuerydsl().applyPagination(pageable,query);

    // 해당 조건에 맞는 데이터 가져오기
    List<Board> list = query.fetch();
    // 해당 조건에 맞는 데이터 갯수
    long count = query.fetchCount();
    return null;
  }
}







