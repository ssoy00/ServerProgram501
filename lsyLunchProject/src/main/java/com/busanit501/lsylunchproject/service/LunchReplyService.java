package com.busanit501.lsylunchproject.service;

import com.busanit501.lsylunchproject.dto.LunchReplyDTO;
import com.busanit501.lsylunchproject.dto.PageRequestDTO;
import com.busanit501.lsylunchproject.dto.PageResponseDTO;

public interface LunchReplyService {
    Long register(LunchReplyDTO lunchReplyDTO);
    LunchReplyDTO read(Long rno);
    void update(LunchReplyDTO lunchReplyDTO);
    void delete(Long rno);
    // 댓글 페이징 처리해서 목록 출력.
    PageResponseDTO<LunchReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);
}