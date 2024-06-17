package com.busanit501.boot501.service;

import com.busanit501.boot501.dto.*;

public interface BoardService {
  Long register(BoardDTO boardDTO);
  //하나 조회, read
  BoardDTO read(Long bno);
  void update(BoardDTO boardDTO);
  void delete(Long bno);

  // 화면에서, 사용자가, 현재 페이지 12, 사이지 : 10개 씩 보고
  // 검색어가 존재하고, 타입도 있고,
  PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
  //댓글 숫자 포함해서 목록 출력하기.
  PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);

  // 댓글 갯수 + 첨부 이미지들
  PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO);
}







