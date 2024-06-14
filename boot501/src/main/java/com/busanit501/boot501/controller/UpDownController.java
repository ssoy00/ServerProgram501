package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.upload.UploadFileDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UpDownController {
    public String upload(UploadFileDTO uploadFileDTO) {
        log.info("UpDownController에서 uploadFileDTO : "+uploadFileDTO);
        return null;
    }
}
