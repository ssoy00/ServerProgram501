package com.lsy1205.lunchex.lunchminiproject.service;


import com.lsy1205.lunchex.lunchminiproject.dto.LunchDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class LunchServiceTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private LunchService lunchService;


  @Test
  public void testInsert() {
    // 임시 TodoVO , 인스턴스 필요하고,
    LunchDTO lunchDTO = LunchDTO.builder()
        .lunchTitle("돈까스33333333333333333333333333")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용333333333333333333")
        .build();
    lunchService.insert(lunchDTO);
  }

  @Test
  public void testListAll() {
    List<LunchDTO> todoList = lunchService.listAll();
    todoList.forEach(dto -> log.info("dto : " + dto));
  }

  @Test
  public void testGetOne() {
    LunchDTO lunchDTO = lunchService.getOne(1L);
    log.info("lunchDTO : " + lunchDTO);
  }

  @Test
  public void testDelete() {
    lunchService.delete(1L);

  }

  @Test
  public void testUpdate() {
//    수정 하기위한 더미 데이터 만들기.
    LunchDTO lunchDTO = LunchDTO.builder()
        .mno(2L)
        .lunchTitle("족발 워너비 고씨")
        .dueDate(LocalDate.of(2024,6,1))
        .finished(false)
        .build();

    lunchService.update(lunchDTO);

  }

}







