package com.app.osca.service.mainpage;

import com.app.osca.dao.CafeDAOKDY;
import com.app.osca.dao.MemberImageDAO;
import com.app.osca.dao.MemberImageDAOKDY;
import com.app.osca.dao.StudyDAOKDY;
import com.app.osca.domain.ImageVO;
import com.app.osca.domain.dto.main.MainCafeDTO;
import com.app.osca.domain.dto.main.MainStudyDTO;
import com.app.osca.mapper.CafeMapperKdy;
import com.app.osca.mapper.MemberImageMapperKDY;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final StudyDAOKDY studyDAOKDY;
    private final MemberImageDAOKDY memberImageDAOKDY;
    private final CafeDAOKDY cafeDAOKDY;

//    스터디 리스트 불러오기 (스크렙순으로)
    @Override
    public List<MainStudyDTO> getMainStudyList() {
        return studyDAOKDY.findStudyListByScrapRank();
    }

//    헤더 멤버 프로필 불러오기
    @Override
    public Optional<ImageVO> getMemberProfile(Long id) {
        return memberImageDAOKDY.findMMemberProfileById(id);
    }

    @Override
    public List<MainCafeDTO> getMainCafeList() {
        return cafeDAOKDY.findCafeListByScrapRank();
    }

}
