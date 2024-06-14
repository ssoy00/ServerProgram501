package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.upload.UploadFileDTO;
import com.busanit501.boot501.dto.upload.UploadResultDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UpDownController {
    @Value("${com.busanit501.upload.path}")
    private String uploadPath;

//    @Tag(name = "파일 업로드 post 방식", description = "파일 업로드 post 방식")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(UploadFileDTO uploadFileDTO){
        log.info("UpDownController에서 uploadFileDTO : "+uploadFileDTO);
        if(uploadFileDTO.getFiles() != null) {
            //임시로 담아둘 이미지 파일 목록 저장소
            final List<UploadResultDTO> imgList = new ArrayList<>();

            uploadFileDTO.getFiles().forEach(multipartFile -> {
                //multipartFile 객체 안에 이미지 파일들이 들어가 있다.
                log.info("파일명 확인: "+multipartFile.getOriginalFilename());
                //원본 파일명
                String originName = multipartFile.getOriginalFilename();
                // 랜덤한 16자리 문자열
                String uuid = UUID.randomUUID().toString();
                // 업로드 경로에 파일 객체를 만들기.
                Path savePath = Paths.get(uploadPath,uuid+"_"+originName);

                boolean imgCheck = false;

                try{
                    //실제 파일에 저장.
                    multipartFile.transferTo(savePath);

                    //해당 파일의 종류를 확인하고, 타입 image/* 로 시작한다면
                    // 썸네일로 변경하기.
                    if(Files.probeContentType(savePath).startsWith("image")){
                        // 이미지 상태 변수 변경.
                        imgCheck = true;
                        // uploadPath 해당 경로에 , 물리 파일 만들기 , 이름 :"s_"+uuid+"_"+originName
                        File thumbFile = new File(uploadPath, "s_"+uuid+"_"+originName);
                        // 원본 이미지 -> thumbFile 곳에 축소해서 저장하기.
                        Thumbnailator.createThumbnail(savePath.toFile(),thumbFile,200,200);
                    }

                } catch (IOException e) {
                   e.printStackTrace();
                }

                //각각 이미지 파일명, 임시 목록에 담기.

//                imgList.add()

            });
        }
        return null;
    }
}
