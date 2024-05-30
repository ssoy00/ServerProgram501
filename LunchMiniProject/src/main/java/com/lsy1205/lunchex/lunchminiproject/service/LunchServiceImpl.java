package com.lsy1205.lunchex.lunchminiproject.service;


import com.lsy1205.lunchex.lunchminiproject.domain.LunchVO;
import com.lsy1205.lunchex.lunchminiproject.dto.LunchDTO;
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
  public List<LunchDTO> listAll() {
    List<LunchVO> sampleLists = lunchMapper.listAll();
    // TodoVo -> LunchDTO
   List<LunchDTO> dtoLists = sampleLists.stream().map(vo -> modelMapper.map(vo, LunchDTO.class))
        .collect(Collectors.toList());
    return dtoLists;
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

}







