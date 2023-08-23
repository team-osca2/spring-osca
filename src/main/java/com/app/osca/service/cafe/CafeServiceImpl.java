package com.app.osca.service.cafe;

import com.app.osca.dao.CafeDAO;
import com.app.osca.domain.CafeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    final private CafeDAO cafeDAO;

    @Override
    public List<CafeVO> getList() {
        return cafeDAO.findAll();
    }
}
