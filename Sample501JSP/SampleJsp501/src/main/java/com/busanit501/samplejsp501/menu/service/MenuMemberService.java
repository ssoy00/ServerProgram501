package com.busanit501.samplejsp501.menu.service;

import com.busanit501.samplejsp501.menu.dao.MenuMemberDAO;
import com.busanit501.samplejsp501.menu.domain.MenuMemberVO;
import com.busanit501.samplejsp501.menu.dto.MenuMemberDTO;
import com.busanit501.samplejsp501.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MenuMemberService {
  INSTANCE;

  private MenuMemberDAO menuMemberDAO;
  private ModelMapper modelMapper;

  MenuMemberService() {
    menuMemberDAO = new MenuMemberDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  // 하나 조회
  public MenuMemberDTO getOneMember(String mid, String mpw) throws Exception {
    MenuMemberVO sample = menuMemberDAO.getWithPasswordMember(mid, mpw);
//    log.info("TodoService , 확인1, sample : " + sample);
    MenuMemberDTO menuMemberDTO = modelMapper.map(sample, MenuMemberDTO.class);
    return menuMemberDTO;
  }
// 회원가입
//  public void insertMember(MemberDTO memberDTO) throws Exception {
//    MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
//    memberDAO.insertMember(memberVO);
//  }
//
//  public void updateUUID(String mid, String uuid) throws Exception {
//    memberDAO.updateUUID(mid, uuid);
//  }
//
//  // 자동로그인 체크 여부
//  public void checkAutoLogin(String mid, boolean autoLogined) throws Exception {
//    memberDAO.checkAutoLogin(mid, autoLogined);
//  }
//
//  public MemberDTO selectUUID(String uuid) throws Exception {
//    MemberVO memberVO = memberDAO.selectUUID(uuid);
//    MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
//    return memberDTO;
//
//  }

}
