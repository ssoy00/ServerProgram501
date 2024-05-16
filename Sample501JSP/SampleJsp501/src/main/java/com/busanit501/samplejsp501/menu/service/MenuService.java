package com.busanit501.samplejsp501.menu.service;

import com.busanit501.samplejsp501.menu.dto.MenuDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum MenuService {
  INSTANCE;

  // 임시 리스트 출력하는 기능.
  public List<MenuDTO> getList() {

    List<MenuDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
      MenuDTO dto = new MenuDTO();
      dto.setMenuNo((long)i);
      dto.setMenuTitle("Sample Menu Title " + i);
      dto.setDueDate(LocalDate.now());
      return dto;
    }).collect(Collectors.toList());
    return listSample;
  }



}
