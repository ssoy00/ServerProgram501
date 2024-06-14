package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.upload.UploadFileDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UpDownController {
    @Value("${com.busanit501.upload.path}")
    private String uploadPath;

//    @Tag(name = "파일 업로드 post 방식", description = "파일 업로드 post 방식")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(UploadFileDTO uploadFileDTO){
        log.info("UpDownController에서 uploadFileDTO : "+uploadFileDTO);
        if(uploadFileDTO.getFiles() != null) {
            uploadFileDTO.getFiles().forEach(multipartFile -> {
                //multipartFile 객체 안에 이미지 파일들이 들어가 있다.
                log.info("파일명 확인: "+multipartFile.getOriginalFilename());
                //원본 파일명
                String originName = multipartFile.getOriginalFilename();
                // 랜덤한 16자리 문자열
                String uuid = UUID.randomUUID().toString();
                // 업로드 경로에 파일 객체를 만들기.
                Path savePath = Paths.get(uploadPath,uuid+"_"+originName);

                try{
                    //실제 파일에 저장.
                    multipartFile.transferTo(savePath);
                } catch (IOException e) {
                   e.printStackTrace();
                }

            });
        }
        return null;
    }
}
