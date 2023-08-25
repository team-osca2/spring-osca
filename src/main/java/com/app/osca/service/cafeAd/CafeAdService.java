package com.app.osca.service.cafeAd;

import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;

import java.util.Optional;

public interface CafeAdService {
    public Optional<CafeAdDetailDTO> getOneCafeAd(Long id);
}
