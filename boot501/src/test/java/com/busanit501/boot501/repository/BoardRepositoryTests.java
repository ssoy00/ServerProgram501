package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

  @Autowired
  BoardRepository boardRepository;

  @Test
  public void testInsert() {
    IntStream.rangeClosed(1,100).forEach(i ->
        {
          Board board = Board.builder()
              .title("오늘 점심 뭐 먹지?" + i)
              .content("한식" + i)
              .writer("이상용"+(i%10))
              .build();
              // 데이터베이스에 추가,
          // save 없으면, 1)추가, 있으면, 2) 수정.
              Board result = boardRepository.save(board);
              log.info("추가한 BNO: " + result.getBno());
        }
        );

  }

}







