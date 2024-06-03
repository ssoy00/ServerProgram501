package com.lsy1205.lunchex.lunchminiproject.mapper;

import com.lsy1205.lunchex.lunchminiproject.domain.LunchVO;
import com.lsy1205.lunchex.lunchminiproject.dto.PageRequestDTO;

import java.util.List;

public interface LunchMapper {
  // 여기 메서드와, LunchMapper.xml 파일(SQL 문장을 보관, id 이름과, 메서드 이름 동일)
  // 주의하기.
  String getTime();

  void insert(LunchVO lunchVO);

  // 페이징 처리가 되어서, 필요한 갯수만 가져오는 목록 리스트
  List<LunchVO> listAll(PageRequestDTO pageRequestDTO);

  LunchVO getOne(Long mno);

  void delete(Long mno);

  void update(LunchVO lunchVO);

  int getCount();
  int getCount2(PageRequestDTO pageRequestDTO);


}













