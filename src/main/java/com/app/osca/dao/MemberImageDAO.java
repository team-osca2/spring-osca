package com.app.osca.dao;

import com.app.osca.mapper.MemberImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberImageDAO {
    private final MemberImageMapper memberImageMapper;
}
