package com.app.osca.service.cafe;

import com.app.osca.dao.CafeDAO;
import com.app.osca.domain.CafeVO;
import com.app.osca.domain.dto.cafe.CafeAdCountDTO;
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
    public List<CafeAdCountDTO> getList(Long memberId) {
        return cafeDAO.findAllByMemberId(memberId);
    }

    @Override
    public Optional<CafeVO> getOne(Long id) {
        return cafeDAO.findById(id);
    }
}
