package com.busanit501.lsylunchproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LunchListReplyCountDTO {
    private Long mno;
    private String title;
    private String writer;
    private LocalDateTime regDate;
    //댓글 갯수 표기 하기 위한 용도.
    private Long replyCount;
}
