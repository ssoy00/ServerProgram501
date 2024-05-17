package com.busanit501.samplejsp501.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MenuDTO2 {
  // 인스턴스 멤버.
  private Long menuNo;
  private String menuTitle;
  private LocalDate menuRegDate;
}







