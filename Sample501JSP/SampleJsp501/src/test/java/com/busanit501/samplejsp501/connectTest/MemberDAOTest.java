package com.busanit501.samplejsp501.connectTest;

import com.busanit501.samplejsp501.todo.dao.MemberDAO;
import com.busanit501.samplejsp501.todo.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MemberDAOTest {
  private MemberDAO memberDAO;

  @BeforeEach
  public void ready() {
    memberDAO = new MemberDAO();
  }

  @Test
  public void getSelectOne() throws Exception {
    MemberVO memberVO = memberDAO.getWithPasswordMember("lsy","1234");
    // 기본 출력이고, 전체 출력
//    System.out.println("memberVO : " + memberVO);
    log.info("memberVO : " + memberVO);

  }
}







