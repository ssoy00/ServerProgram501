package com.lsy1205.lunchex.lunchminiproject.service;

import com.lsy1205.lunchex.lunchminiproject.dto.LunchDTO;
import com.lsy1205.lunchex.lunchminiproject.dto.PageRequestDTO;
import com.lsy1205.lunchex.lunchminiproject.dto.PageResponseDTO;

import java.util.List;

public interface LunchService {
  void insert(LunchDTO lunchDTO);
  // 맵퍼, listAll 반환 타입 : TodoVO
  // 서비스에서, TodoDTO 로 모두 변환하기.

  // 페이징 추가.
//  List<LunchDTO> listAll(PageRequestDTO pageRequestDTO);
  // 변경, PageResponseDTO 타입으로 변환 해야 함.
  PageResponseDTO<LunchDTO> listAll(PageRequestDTO pageRequestDTO);
  LunchDTO getOne(Long tno);
  void delete(Long tno);
  void update(LunchDTO lunchDTO);

  int getCount();
  int getCount2(PageRequestDTO pageRequestDTO);
}













