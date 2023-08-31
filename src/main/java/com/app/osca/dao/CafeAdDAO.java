package com.app.osca.dao;

import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.cafeAd.CafeAdDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdUpdateDTO;
import com.app.osca.mapper.CafeAdMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CafeAdDAO {
    private final CafeAdMapper cafeAdMapper;

//    홍보물 상세보기
    public Optional<CafeAdDetailDTO> findCafeAndCafeAdById(Long id){
        return Optional.ofNullable(cafeAdMapper.select(id));
    }

//    내가 만든 홍보물들
    public List<CafeAdDTO> findAllByMemberIdAndBlockedIsOrderByCafeAdDeadlineDateOrderById(Long memberId, Integer blocked){
        return cafeAdMapper.selectAllMyCafes(memberId, blocked);
    }
    
//    홍보물 기간 연장
    public StateEnum modify(CafeAdUpdateDTO cafeAdUpdateDTO){
        return cafeAdMapper.update(cafeAdUpdateDTO) == 1 ? StateEnum.SUCCESS  : StateEnum.FAIL;
    }
}

