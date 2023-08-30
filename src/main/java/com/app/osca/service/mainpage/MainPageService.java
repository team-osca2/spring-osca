package com.app.osca.service.mainpage;

import com.app.osca.domain.ImageVO;
import com.app.osca.domain.dto.main.MainCafeDTO;
import com.app.osca.domain.dto.main.MainStudyDTO;

import java.util.List;
import java.util.Optional;

public interface MainPageService {
    //    스터디 리스트 불러오기 (스크렙순으로)
    public List<MainStudyDTO> getMainStudyList();

    //    헤더 멤버 프로필 불러오기
    public Optional<ImageVO> getMemberProfile(Long id);

//    카페 리스트 불러오기 (스크랩 순으로)
    public List<MainCafeDTO> getMainCafeList();


}
