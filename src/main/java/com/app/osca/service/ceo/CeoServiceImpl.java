package com.app.osca.service.ceo;

import com.app.osca.dao.CeoDAO;
import com.app.osca.dao.MemberDAO;
import com.app.osca.domain.StateEnum;
import com.app.osca.domain.dto.ceo.CeoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CeoServiceImpl implements CeoService {
    final private CeoDAO ceoDAO;

    @Override
    public void joinPoint(Long memberId, boolean isFirstAccount) {
        if ( isFirstAccount ) {
            ceoDAO.giveWelcomePoint(memberId);
        } else {
            ceoDAO.givePoint(memberId);
        }
    }

    @Override
    public StateEnum usePoint(CeoDTO ceoDTO) {
        return ceoDAO.modify(ceoDTO);
    }

    @Override
    public Optional<Integer> getPoint(Long memberId) {
        return ceoDAO.findByMemberId(memberId);
    }
}
