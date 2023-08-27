package com.app.osca.service.cafeAd;

import com.app.osca.dao.CafeAdDAO;
import com.app.osca.domain.dto.cafeAd.CafeAdDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdImagesDTO;
import com.app.osca.domain.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CafeAdServiceImpl implements CafeAdService {

    final private CafeAdDAO cafeAdDAO;

    @Override
    public Optional<CafeAdDetailDTO> getOneCafeAd(Long id) {
        final Optional<CafeAdDetailDTO> foundCafeAd = cafeAdDAO.findCafeAndCafeAdById(id);
        foundCafeAd.ifPresent(cafeAdDetailDTO -> cafeAdDetailDTO.setCafeImages(null));
        return foundCafeAd;
    }

    @Override
    public List<CafeAdImagesDTO> getCafeAdList(Criteria criteria) {
        return null;
    }

    @Override
    public List<CafeAdDTO> getMyCafeAdList(Long memberId, Integer blocked) {
        return cafeAdDAO.findAllByMemberIdAndBlockedIsOrderByCafeAdDeadlineDateOrderById(memberId, blocked);
    }
}
