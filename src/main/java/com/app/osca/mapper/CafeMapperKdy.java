package com.app.osca.mapper;

import com.app.osca.domain.dto.main.MainCafeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMapperKdy {

    public List<MainCafeDTO> selectListByScrap();
}
