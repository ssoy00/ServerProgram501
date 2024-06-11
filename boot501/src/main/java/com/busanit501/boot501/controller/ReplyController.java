package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.ReplyDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

    @Tag(name = "댓글 등록 post 방식", description = "댓글 등록 post 방식")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    //ResponseEntity, 데이터 + http 상태코드 같이 전달 도구.
    public ResponseEntity<Map<String,Long>> register(
            //@RequestBody -> JSON 문자열.  , 키: 값의 구조 형태의 중간 데이터 타입,
            // JSON 문자열 <--Jackson 컨버터 --> DTO
            @RequestBody ReplyDTO replyDTO) {
        log.info("ReplyController의 register ,replyDTO 확인: "+replyDTO);
        // 응답 해줄 더미 데이터 만들기.
        Map<String,Long> resultMap = Map.of("rno",123L);

        return ResponseEntity.ok(resultMap);

    }

}
