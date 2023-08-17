package com.app.osca.dao;

import com.app.osca.mapper.StudyScrapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudyScrapDAO {
    private final StudyScrapMapper studyScrapMapper;
}
