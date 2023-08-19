package com.app.osca.dao;

import com.app.osca.mapper.JobCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JobCategoryDAO {
    private final JobCategoryMapper jobCategoryMapper;
}
