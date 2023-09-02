package com.app.osca.service.cafe;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.dto.cafe.CafeAdCountDTO;

import java.util.List;
import java.util.Optional;

public interface CafeService {
    public List<CafeVO> getList();

    public List<CafeAdCountDTO> getList(Long memberId);

    public Optional<CafeVO> getOne(Long id);
}
