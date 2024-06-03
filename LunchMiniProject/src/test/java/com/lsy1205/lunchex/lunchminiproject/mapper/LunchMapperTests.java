package com.lsy1205.lunchex.lunchminiproject.mapper;


import com.lsy1205.lunchex.lunchminiproject.domain.LunchVO;
import com.lsy1205.lunchex.lunchminiproject.dto.PageRequestDTO;
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
public class LunchMapperTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private LunchMapper lunchMapper;

  @Test
  public void testGetTime() {
    log.info("시간 테스트 : " + lunchMapper.getTime());
  }

  @Test
  public void testInsert() {
    // 임시 LunchVO , 인스턴스 필요하고,
    LunchVO lunchVO = LunchVO.builder()
        .lunchTitle("돈까스22222222222222222222222222")
        .dueDate(LocalDate.now())
        .finished(false)
        .writer("이상용222222222222222222222222222")
        .build();
    lunchMapper.insert(lunchVO);
  }

//  @Test
//  public void testSelect() {
//    List<LunchVO> todoList = lunchMapper.listAll();
//    todoList.forEach(vo -> log.info("vo : " + vo));
//  }

  @Test
  public void testGetOne() {
    LunchVO lunchVO = lunchMapper.getOne(35L);
    log.info("lunchVO : " + lunchVO);
  }

  @Test
  public void testDelete() {
    lunchMapper.delete(36L);

  }

  @Test
  public void testUpdate() {
    // 변경할 임시 데이터
    LunchVO lunchVO = LunchVO.builder()
        .mno(1L)
        .lunchTitle("초밥 먹기")
        .dueDate(LocalDate.of(2024,5,31))
        .finished(false)
        .build();

    lunchMapper.update(lunchVO);
  }
  // 페이징 관련 테스트 재사용
  @Test
  public void testSelectPaging() {
    //페이징 정보를 가지고 있는 임시 더미 데이터, PageRequestDTO
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .build();

    List<LunchVO> todoList = lunchMapper.listAll(pageRequestDTO);
    todoList.forEach(vo -> log.info("vo : " + vo));
  }

  // 전체 갯수를 구하는 테스트 .
  @Test
  public void testGetCount() {
    int result = lunchMapper.getCount();
    log.info("result todo 전체 갯수 : " + result);
  }

}







