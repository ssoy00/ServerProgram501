package com.busanit501.lsylunchproject.repository;

import com.busanit501.lsylunchproject.domain.Lunch;
import com.busanit501.lsylunchproject.domain.LunchReply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class LunchReplyRepositoryTest {
    @Autowired
    private LunchReplyRepository lunchReplyRepository;

    @Test
    public void testInsert() {
        //실제 디비 각자 데이터에 따라서 다름.
        // 현재 bno = 900
        Long mno = 305L;

        Lunch lunch = Lunch.builder()
                .mno(mno)
                .build();

        LunchReply lunchReply = LunchReply.builder()
                .lunch(lunch)
                .replyText("오늘 점심은 면으로")
                .replyer("이상용")
                .build();

        lunchReplyRepository.save(lunchReply);

    } //

    @Transactional
    @Test
    public void testBoardReplies() {
        // 각자 테이블의 데이터 내용에 맞게.
        Long mno = 305L;

        Pageable pageable =
                PageRequest.of(0,10,
                        Sort.by("rno").descending());

        Page<LunchReply> result = lunchReplyRepository.listOfBoard(mno,pageable);

        result.getContent().forEach(lunchReply -> {
            log.info("lunchReply 확인 : " +lunchReply);
        });

    }

}

