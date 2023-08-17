package com.app.osca.dao;

import com.app.osca.mapper.SkillListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SkillListDAO {
    private final SkillListMapper skillListMapper;
}
