package com.app.osca.dao;

import com.app.osca.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ImageDAO {
    private final ImageMapper imageMapper;
}
