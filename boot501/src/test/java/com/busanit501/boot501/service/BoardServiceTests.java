package com.busanit501.boot501.service;

import com.busanit501.boot501.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  BoardService boardService;

  @Test
  public  void testInsert() {
    // 화면에서 넘어온 더미 데이터 만들기. DTO 타입.
    BoardDTO boardDTO = BoardDTO.builder()
        .title("내일 모하니?")
        .content("부모님 인사하기")
        .writer("이상용")
        .build();

    Long bno = boardService.register(boardDTO);
    log.info("추가 후에 반환 게시글 번호 bno : " + bno);

  }
}







