package com.app.osca.service.cafe;

import com.app.osca.dao.CafeDAO;
import com.app.osca.domain.CafeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    final private CafeDAO cafeDAO;

    @Override
    public List<CafeVO> getList() {
        return cafeDAO.findAll();
    }

    @Override
    public Optional<CafeVO> getOne(Long id) {
        return cafeDAO.findById(id);
    }
}
