package com.app.osca.mapper;

import com.app.osca.domain.dto.main.MainCafeDTO;
import com.app.osca.domain.dto.main.MainStudyDTO;
import groovy.io.FileType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class MainPageImageTestKDY {

    @Autowired
    private StudyMapperKdy studyMapperKdy;

    @Autowired
    private CafeMapperKdy cafeMapperKdy;

//    카페
    @Test
    public void mainImageTestCafe(){

        List<MainCafeDTO> mainCafeDTOS = cafeMapperKdy.cafeListByScrap();

        log.info("{}...............", mainCafeDTOS.toString());
    }

//    스터디
    @Test
    public void mainImageTestsStudy(){

        List<MainStudyDTO> mainStudyDTOS = studyMapperKdy.studyListByScrap();

        log.info("{}....................", mainStudyDTOS.toString());
    }

    @Test
    public void insertTest(){

    }
}
