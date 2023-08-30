package com.app.osca.mapper;

import com.app.osca.domain.dto.main.MainCafeDTO;
import com.app.osca.domain.dto.main.MainStudyDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MainPageImageTestKDY {

    @Autowired
    private StudyMapperKdy studyMapperKdy;

    @Autowired
    private CafeMapperKdy cafeMapperKdy;

    @Autowired
    private MemberImageMapperKDY memberImageMapperKDY;

//    카페
    @Test
    public void mainImageTestCafe(){

        List<MainCafeDTO> mainCafeDTOS = cafeMapperKdy.selectListByScrap();

        log.info("{}...............", mainCafeDTOS.toString());
    }

//    스터디
    @Test
    public void mainImageTestsStudy(){

        List<MainStudyDTO> mainStudyDTOS = studyMapperKdy.studyListByScrap();

        log.info("{}....................", mainStudyDTOS.toString());
    }

//    회원 프로필 이미지 (헤더)
    @Test
    public void mainPageMemberImageTest(){
        memberImageMapperKDY.selectMemberProfileImage(201L).ifPresent((data) -> {
            log.info("{}.............",data);
        });
    }
}
