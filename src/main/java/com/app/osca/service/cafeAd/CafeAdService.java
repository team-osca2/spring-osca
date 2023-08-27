package com.app.osca.service.cafeAd;

import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdImagesDTO;
import com.app.osca.domain.paging.Criteria;

import java.util.List;
import java.util.Optional;

public interface CafeAdService {
    public Optional<CafeAdDetailDTO> getOneCafeAd(Long id);

    public List<CafeAdImagesDTO> getCafeAdList(Criteria criteria);
}
