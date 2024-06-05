package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

  @Autowired
  BoardRepository boardRepository;

  @Test
  public void testInsert() {
    IntStream.rangeClosed(1, 100).forEach(i ->
        {
          Board board = Board.builder()
              .title("오늘 점심 뭐 먹지?" + i)
              .content("한식" + i)
              .writer("이상용" + (i % 10))
              .build();
          // 데이터베이스에 추가,
          // save 없으면, 1)추가, 있으면, 2) 수정.
          Board result = boardRepository.save(board);
          log.info("추가한 BNO: " + result.getBno());
        }
    );

  } // inset test

  @Test
  public void testSelect() {
    Long bno = 100L;
    Optional<Board> result = boardRepository.findById(bno);
    Board board = result.orElseThrow();
    log.info("조회 결과 : " + board);
  }

  @Test
  public void testUpdate() {
    Long bno = 100L;
    Optional<Board> result = boardRepository.findById(bno);
    Board board = result.orElseThrow();

    log.info("조회 결과1 전 : " + board);
    board.changeTitleAndContent("오늘 점심 뭐 먹죠 수정버전","로제 떡볶이, 냉라면, 족발");
    // 반영.
    boardRepository.save(board);
    log.info("조회 결과2 후: " + board);

  }

  @Test
  public void testDelete() {
    Long bno = 100L;
    // 반영.
    boardRepository.deleteById(100L);
    log.info("조회 결과2 후: 디비상에서 삭제 여부 확인 하기.");

  }

}







