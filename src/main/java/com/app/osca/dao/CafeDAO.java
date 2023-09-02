package com.app.osca.dao;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.cafe.CafeAdCountDTO;
import com.app.osca.mapper.CafeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CafeDAO {
    private final CafeMapper cafeMapper;

    public List<CafeVO> findAll(){
        return cafeMapper.selectAll();
    }

    public Optional<CafeVO> findById(Long id){
        return Optional.ofNullable(cafeMapper.select(id));
    }

    public List<CafeAdCountDTO> findAllByMemberId(Long memberId){return cafeMapper.selectByMemberId(memberId);}

    public StateEnum save(CafeVO cafeVO) {
        return StateEnum.toStateEnum(cafeMapper.insert(cafeVO));
    }
}

