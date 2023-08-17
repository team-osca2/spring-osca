package com.app.osca.dao;

import com.app.osca.mapper.MemberJobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberJobDAO {
    private final MemberJobMapper memberJobMapper;
}
