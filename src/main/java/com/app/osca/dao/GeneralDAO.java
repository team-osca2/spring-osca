package com.app.osca.dao;

import com.app.osca.mapper.GeneralMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GeneralDAO {
    private final GeneralMapper generalMapper;
}
