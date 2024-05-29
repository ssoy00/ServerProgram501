package com.busanit501.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

  // 기본이 true 인데, 만약 해당 빈이 없다면, 널 오류가 발생.
  // 널도 허용가능.
  @Autowired(required = false)
  private TodoMapper todoMapper;

  @Test
  public void testGetTime() {
    log.info("시간 테스트 : " + todoMapper.getTime());
  }
}







