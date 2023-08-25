package com.app.osca.service.cafeScrap;

import com.app.osca.dao.MypageCafeScrapDAO;
import com.app.osca.domain.dto.CafeScrapDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageCafeScrapServiceImpl implements MypageCafeScrapService {
    private final MypageCafeScrapDAO cafeScrapDAO;

    @Override
    public List<CafeScrapDTO> getList(Long memberId) {
        return cafeScrapDAO.findBymemberId(memberId);
    }

    @Override
    public void remove(Long id) {
        cafeScrapDAO.delete(id);
    }
}
