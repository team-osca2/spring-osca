package com.app.osca.dao;

import com.app.osca.domain.CafeVO;
import com.app.osca.mapper.CafeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CafeDAO {
    private final CafeMapper cafeMapper;

    public List<CafeVO> findAll(){
        return cafeMapper.selectAll();
    }
}
