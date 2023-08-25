package com.app.osca.service.cafe;

import com.app.osca.domain.CafeVO;

import java.util.List;
import java.util.Optional;

public interface CafeService {
    public List<CafeVO> getList();

    public Optional<CafeVO> getOne(Long id);
}
