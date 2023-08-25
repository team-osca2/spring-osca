package com.app.osca.service.general;

import com.app.osca.dao.MypageGeneralDAO;
import com.app.osca.domain.GeneralVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageGeneralServiceImpl implements MypageGeneralService {
    private final MypageGeneralDAO generalDAO;

    @Override
    public void write(GeneralVO generalVO) {
        generalDAO.save(generalVO);
    }

    @Override
    public Optional<GeneralVO> getGeneralInfo(Long memberId) {
        return generalDAO.findById(memberId);
    }

    @Override
    public void modify(GeneralVO generalVO) {
        generalDAO.setMemberInfo(generalVO);
    }
}
