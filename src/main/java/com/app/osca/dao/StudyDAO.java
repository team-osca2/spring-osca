package com.app.osca.dao;

import com.app.osca.domain.StudyVO;
import com.app.osca.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudyDAO {
    private final StudyMapper studyMapper;

    public void join(StudyVO studyVO){studyMapper.insert(studyVO);}
}
