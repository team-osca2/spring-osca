package com.app.osca.dao;

import com.app.osca.mapper.JobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JobDAO {
    private final JobMapper jobMapper;
}

