package com.busanit501.samplejsp501.menu.service;

import com.busanit501.samplejsp501.menu.dto.MenuMemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MenuMemberServiceTests {

  private MenuMemberService menuMemberService;

  // 아래에 다른 메서드들이 실행되기전에, 먼저 실행이 됨.(역할, todoService 초기화 해주는 역할)
  @BeforeEach
  public void ready(){
    menuMemberService = MenuMemberService.INSTANCE;
  }

  @Test
  public  void getOneMemberTest() throws Exception {

    // 인자 값으로 TodoDTO 를 사용해야함.
    MenuMemberDTO menuMemberDTO = menuMemberService.getOneMember("lsy","1234");
    log.info("menuMemberDTO : "+ menuMemberDTO);
  }

  @Test
  public  void updateUUID() throws Exception {
    menuMemberService.updateUUID("lsy","testuuid3333333333333333333333333");
    // 디비 콘솔에서 확인하기.
    }
//
//  @Test
//  public  void checkAutoLogin() throws Exception {
//    memberService.checkAutoLogin("lsy",true);
//    // 디비 콘솔에서 확인하기.
//  }
//
//
//  @Test
//  public  void selectUUID() throws Exception {
//   MemberDTO memberDTO = memberService.selectUUID("d508307d-2f79-4f48-91f7-8a52568e8fbe");
//   log.info("memberDTO : " + memberDTO);
//    // 디비 콘솔에서 확인하기.
//  }
//
  @Test
  public  void insertMember() throws Exception {
    MenuMemberDTO menuMemberDTO = MenuMemberDTO.builder()
        .mid("lsy05232")
        .mpw("1234")
        .mname("이상용05232")
        .build();

  menuMemberService.insertMember(menuMemberDTO);
// 디비 콘솔에서 확인하기.
  }
}








