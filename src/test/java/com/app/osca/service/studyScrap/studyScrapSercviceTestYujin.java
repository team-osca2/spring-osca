package com.app.osca.service.studyScrap;

import com.app.osca.domain.dto.StudyScrapDTO;
import com.app.osca.service.studyScrapService.MypageStudyScrapSercvice;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class studyScrapSercviceTestYujin {
    @Autowired
    private MypageStudyScrapSercvice mypageStudyScrapSercvice;

    @Test
    public void selectTest() {
        mypageStudyScrapSercvice.getScrapList(2L).stream().map(StudyScrapDTO::toString).forEach(log::info);
    }
}
