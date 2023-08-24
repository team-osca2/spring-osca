package com.app.osca.dao;

import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.mapper.CafeAdMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CafeAdDAO {
    private final CafeAdMapper cafeAdMapper;

    public Optional<CafeAdDetailDTO> findByID(Long id){
        return cafeAdMapper.select(id);
    }
}
