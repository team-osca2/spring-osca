package com.app.osca.dao;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.dto.main.MainCafeDTO;
import com.app.osca.mapper.CafeMapper;
import com.app.osca.mapper.CafeMapperKdy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CafeDAOKDY {

    private final CafeMapperKdy cafeMapperKdy;

    public List<MainCafeDTO> findCafeListByScrapRank(){
        return cafeMapperKdy.selectListByScrap();
    }
}

