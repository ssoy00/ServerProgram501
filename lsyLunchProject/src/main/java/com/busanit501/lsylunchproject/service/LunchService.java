package com.busanit501.lsylunchproject.service;

import com.busanit501.lsylunchproject.dto.LunchDTO;
import com.busanit501.lsylunchproject.dto.LunchListReplyCountDTO;
import com.busanit501.lsylunchproject.dto.PageRequestDTO;
import com.busanit501.lsylunchproject.dto.PageResponseDTO;

public interface LunchService {
    Long register(LunchDTO lunchDTO);
    //하나 조회, read
    LunchDTO read(Long mno);
    void update(LunchDTO lunchDTO);
    void delete(Long mno);

    // 화면에서, 사용자가, 현재 페이지 12, 사이지 : 10개 씩 보고
    // 검색어가 존재하고, 타입도 있고,
    PageResponseDTO<LunchDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO<LunchListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
