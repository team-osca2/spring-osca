package com.app.osca.dao;

import com.app.osca.mapper.StudySkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudySkillDAO {
    private final StudySkillMapper studySkillMapper;
}
