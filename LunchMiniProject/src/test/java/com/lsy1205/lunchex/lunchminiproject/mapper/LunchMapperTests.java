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

  // 검색시, 타입에 관련된 테스트
  // 화면 -> 서버, 페이징 정보를 담아서 보내고 , PageRequestDTO + 검색, 필터 준비물
  @Test
  public void testSelectTypes() {
    // 테스트용 더미 PageRequestDTO 만들기.
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .keyword("족발")
        // 검색 조건이, 작성자 또는 제목
        .types(new String[]{"t","w"})
        .from(LocalDate.of(2024,5,1))
        .to(LocalDate.of(2024,6,3))
        .finished(false)
        .build();

    List<LunchVO> voList  = lunchMapper.listAll(pageRequestDTO);
    voList.forEach(vo -> log.info("vo : " + vo ));
  }

  @Test
  public void testGetCountWithSearch() {
    // 테스트용 더미 PageRequestDTO 만들기.
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
        .page(1)
        .size(10)
        .keyword("족발")
        // 검색 조건이, 작성자 또는 제목
        .types(new String[]{"t","w"})
        .from(LocalDate.of(2024,5,1))
        .to(LocalDate.of(2024,5,31))
        .finished(true)
        .build();
    int result = lunchMapper.getCount2(pageRequestDTO);
    log.info("result todo 전체 갯수 : " + result);
  }

}







