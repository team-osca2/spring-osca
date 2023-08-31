package com.app.osca.dao;

import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.ceo.CeoDTO;
import com.app.osca.mapper.CeoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CeoDAO {
    private final CeoMapper ceoMapper;

    public void giveWelcomePoint(Long memberId) {
         ceoMapper.insertWelcomePoint(memberId);
    }

    public void givePoint(Long memberId){
        ceoMapper.insertPoint(memberId);
    }

    public StateEnum modify(CeoDTO ceoDTO){ return StateEnum.toStateEnum(ceoMapper.updatePoint(ceoDTO));}

    public Optional<Integer> findByMemberId(Long memberId){return Optional.ofNullable(ceoMapper.selectMemberPoint(memberId));}
}
