package com.busanit501.lsylunchproject.service;

import com.busanit501.lsylunchproject.domain.Lunch;
import com.busanit501.lsylunchproject.domain.LunchReply;
import com.busanit501.lsylunchproject.dto.LunchReplyDTO;
import com.busanit501.lsylunchproject.dto.PageRequestDTO;
import com.busanit501.lsylunchproject.dto.PageResponseDTO;
import com.busanit501.lsylunchproject.repository.LunchReplyRepository;
import com.busanit501.lsylunchproject.repository.LunchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class LunchReplyServiceImpl implements LunchReplyService {

    private final LunchReplyRepository lunchReplyRepository;
    private final LunchRepository lunchRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(LunchReplyDTO lunchReplyDTO) {
        LunchReply lunchReply = modelMapper.map(lunchReplyDTO, LunchReply.class);
        // replyDTO 들어 있는 게시글 번호로, 해당 엔티티 객체를 가지고 오기.
        Optional<Lunch> result = lunchRepository.findById(lunchReplyDTO.getMno());
        Lunch lunch = result.orElseThrow();
        lunchReply.setLunch(lunch);
        Long rno = lunchReplyRepository.save(lunchReply).getRno();

        return rno;
    }

    @Override
    public LunchReplyDTO read(Long rno) {
        Optional<LunchReply> lunchReplyOptional = lunchReplyRepository.findById(rno);
        LunchReply lunchReply = lunchReplyOptional.orElseThrow();
        log.info("확인1 Read lunchReply: " + lunchReply);
        LunchReplyDTO lunchReplyDTO = modelMapper.map(lunchReply, LunchReplyDTO.class);
        log.info("확인2 Read lunchReplyDTO: " + lunchReplyDTO);
        lunchReplyDTO.setMno(lunchReply.getLunch().getMno());
        log.info("확인3 Read lunchReplyDTO: " + lunchReplyDTO);
        return lunchReplyDTO;
    }

    @Override
    public void update(LunchReplyDTO lunchReplyDTO) {
        Optional<LunchReply> lunchReplyOptional = lunchReplyRepository.findById(lunchReplyDTO.getRno());
        LunchReply lunchReply = lunchReplyOptional.orElseThrow();
        lunchReply.chageText(lunchReplyDTO.getReplyText());
        lunchReplyRepository.save(lunchReply);
    }

    @Override
    public void delete(Long rno) {
        //유효성 체크.
        Optional<LunchReply> lunchReplyOptional = lunchReplyRepository.findById(rno);
        LunchReply lunchReply = lunchReplyOptional.orElseThrow();
        lunchReplyRepository.deleteById(rno);
    }

    @Override
    public PageResponseDTO<LunchReplyDTO> getListOfBoard
            (Long mno, PageRequestDTO pageRequestDTO) {
        //페이징 조건 정의하기.
//      Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1 <=0 ? 0 :pageRequestDTO.getPage()-1,pageRequestDTO.getSize(), Sort.by("rno").descending());
//        Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1 <=0 ? 0 :pageRequestDTO.getPage()-1, pageRequestDTO.getSize(),Sort.by("rno").descending());
        //오름차순
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage()-1 <=0 ? 0 :pageRequestDTO.getPage()-1, pageRequestDTO.getSize(), Sort.by("rno").ascending());
        Page<LunchReply> result = lunchReplyRepository.listOfBoard(mno,pageable);

        List<LunchReplyDTO> dtoList = result.getContent().stream()
                .map(lunchReply ->{
                    LunchReplyDTO lunchReplyDTO = modelMapper.map(lunchReply,LunchReplyDTO.class);
                    lunchReplyDTO.setMno(lunchReply.getLunch().getMno());
                    return lunchReplyDTO;
                })
                .collect(Collectors.toList());

        PageResponseDTO<LunchReplyDTO> pageResponseDTO = PageResponseDTO.<LunchReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();

        return pageResponseDTO;
    }
}
