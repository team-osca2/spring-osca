package com.app.osca.dao;

import com.app.osca.domain.StudyImageVO;
import com.app.osca.mapper.StudyImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudyImageDAO {
    private final StudyImageMapper studyImageMapper;

    public void save(StudyImageVO studyImageVO){studyImageMapper.insert(studyImageVO);}
}
