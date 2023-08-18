package com.app.osca.dao;

import com.app.osca.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudyDAO {
    private final StudyMapper studyMapper;
}
