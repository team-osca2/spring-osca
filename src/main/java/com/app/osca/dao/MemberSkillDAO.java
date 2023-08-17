package com.app.osca.dao;

import com.app.osca.mapper.MemberSkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberSkillDAO {
    private final MemberSkillMapper memberSkillMapper;
}
