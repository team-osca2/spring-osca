package com.app.osca.controller;

import com.app.osca.controller.study.StudyController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyControllerTest {

    @Autowired
    private StudyController studyController;

    @Test
    public void studyMainUriTest(){
        log.info("...    " + studyController.studyMain());
    }

    @Test
    public void myStudyUriTest(){
        log.info("...     " + studyController.myStudy());
    }

    @Test
    public void studyCheckTest(){
        log.info("...     " + studyController.studyCheck());
    }

    @Test
    public void studyDetailTest(){
        log.info("...     " + studyController.studyDetail());
    }

    @Test
    public void studyOpenTest(){
        log.info("...     " + studyController.studyOpen());
    }
}
