package com.busanit501.boot501.service;

import com.busanit501.boot501.shop.repository.ItemImgRepository;
import com.busanit501.boot501.shop.service.ItemImgService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ItemImgServiceTests {
    @Autowired
    ItemImgService itemImgService;
    @Autowired
    ItemImgRepository itemImgRepository;

    @Test
    public void testDelete() {
        Long id = 5L;
        itemImgRepository.deleteById(id);

    }

}
