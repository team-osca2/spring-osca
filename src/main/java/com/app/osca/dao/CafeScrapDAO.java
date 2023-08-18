package com.app.osca.dao;

import com.app.osca.mapper.CafeScrapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CafeScrapDAO {
    private final CafeScrapMapper cafeScrapMapper;
}
