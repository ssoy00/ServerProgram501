package com.lsy1205.lunchex.lunchminiproject.service;


import com.lsy1205.lunchex.lunchminiproject.domain.LunchVO;
import com.lsy1205.lunchex.lunchminiproject.dto.LunchDTO;
import com.lsy1205.lunchex.lunchminiproject.dto.PageRequestDTO;
import com.lsy1205.lunchex.lunchminiproject.dto.PageResponseDTO;
import com.lsy1205.lunchex.lunchminiproject.mapper.LunchMapper;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class LunchServiceImpl implements LunchService {

  @Autowired
  private LunchMapper lunchMapper;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public void insert(LunchDTO lunchDTO) {

    LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);
    lunchMapper.insert(lunchVO);
  }


  @Override
  public PageResponseDTO<LunchDTO> listAll(PageRequestDTO pageRequestDTO) {
    // PageResponseDTO 내용물 다 있다.
    // 1) PageRequestDTO 2) 나눠서 가져온 데이터 목록 3) 전체 갯수
    List<LunchVO> sampleLists = lunchMapper.listAll(pageRequestDTO);
    // TodoVo -> LunchDTO
    List<LunchDTO> dtoLists = sampleLists.stream().map(vo -> modelMapper.map(vo, LunchDTO.class))
        .collect(Collectors.toList());
    // 3) 전체 갯수
    //
    int total = lunchMapper.getCount();

    //반환 해야할 PageResponseDTO ,
    PageResponseDTO<LunchDTO> pageResponseDTO = PageResponseDTO.<LunchDTO>withAll()
        .pageRequestDTO(pageRequestDTO)
        .dtoList(dtoLists)
        .total(total)
        .build();


    return pageResponseDTO;
  }

  @Override
  public LunchDTO getOne(Long tno) {
    LunchVO lunchVO = lunchMapper.getOne(tno);
    LunchDTO lunchDTO = modelMapper.map(lunchVO, LunchDTO.class);
    return lunchDTO;
  }

  @Override
  public void delete(Long tno) {
    lunchMapper.delete(tno);
  }

  @Override
  public void update(LunchDTO lunchDTO) {
    LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);
    lunchMapper.update(lunchVO);
  }

  @Override
  public int getCount() {
    int result = lunchMapper.getCount();
    return result;
  }

}







