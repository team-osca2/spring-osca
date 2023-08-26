package com.app.osca.dao;

import com.app.osca.domain.StudyVO;
import com.app.osca.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyDAO {
    private final StudyMapper studyMapper;

//    public void join(StudyVO studyVO){studyMapper.insert(studyVO);}

    public void getStudy(StudyVO studyVO){studyMapper.selectOneStudy(studyVO);}

}
