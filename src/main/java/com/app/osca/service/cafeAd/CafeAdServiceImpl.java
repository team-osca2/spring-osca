package com.app.osca.service.cafeAd;

import com.app.osca.dao.CafeAdDAO;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CafeAdServiceImpl implements CafeAdService {

    final private CafeAdDAO cafeAdDAO;

    @Override
    public Optional<CafeAdDetailDTO> getOneCafeAd(Long id) {
        final Optional<CafeAdDetailDTO> foundCafeAd = cafeAdDAO.findByID(id);
        foundCafeAd.ifPresent(cafeAdDetailDTO -> cafeAdDetailDTO.setCafeImages(null));
        return foundCafeAd;
    }
}
