package com.lsy1205.lunchex.lunchminiproject.service;

import com.lsy1205.lunchex.lunchminiproject.dto.LunchDTO;

import java.util.List;

public interface LunchService {
  void insert(LunchDTO lunchDTO);
  // 맵퍼, listAll 반환 타입 : TodoVO
  // 서비스에서, TodoDTO 로 모두 변환하기.
  List<LunchDTO> listAll();
  LunchDTO getOne(Long tno);
  void delete(Long tno);
  void update(LunchDTO lunchDTO);

}













