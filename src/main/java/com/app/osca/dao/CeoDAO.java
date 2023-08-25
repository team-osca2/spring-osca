package com.app.osca.dao;

import com.app.osca.mapper.CeoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
