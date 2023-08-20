package com.app.osca.mapper;

import com.app.osca.domain.ImageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {
    public void insert(ImageVO imageVO);
}
