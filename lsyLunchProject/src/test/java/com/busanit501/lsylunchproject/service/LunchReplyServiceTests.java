package com.busanit501.lsylunchproject.service;

import com.busanit501.lsylunchproject.dto.LunchReplyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class LunchReplyServiceTests {
    @Autowired
    private LunchReplyService lunchReplyService;

    @Test
    public void testInsert() {

        // 작성할 더미 댓글 필요함.
        LunchReplyDTO lunchReplyDTO = LunchReplyDTO.builder()
                .mno(305L)
                .replyText("오늘 점심? 참치김밥 + 컵라면")
                .replyer("이상용")
                .build();
        Long rno = lunchReplyService.register(lunchReplyDTO);
        log.info("작성한 댓글 번호 : " + rno);
    }

}

