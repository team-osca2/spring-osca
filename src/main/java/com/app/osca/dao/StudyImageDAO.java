package com.app.osca.dao;

import com.app.osca.mapper.StudyImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudyImageDAO {
    private final StudyImageMapper studyImageMapper;
}
