package com.app.osca.service.study;

import com.app.osca.domain.StudyVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudyTest {

    @Autowired
    private StudyService studyService;

    @Test
    public void studyInsertTest(){
        StudyVO studyVO = new StudyVO();
        studyVO.setStudyTitle("게시글1");
        studyVO.setStudyContents("게시글 내용 1");
        studyVO.setStudyTotal(6);
        studyVO.setMemberId(1L);
        studyService.join(studyVO);
    }
}
