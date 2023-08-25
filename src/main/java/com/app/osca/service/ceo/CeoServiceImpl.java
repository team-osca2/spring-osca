package com.app.osca.service.ceo;

import com.app.osca.dao.CeoDAO;
import com.app.osca.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
