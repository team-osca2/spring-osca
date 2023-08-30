package com.app.osca.dao;

import com.app.osca.domain.dto.main.MainStudyDTO;
import com.app.osca.mapper.StudyMapperKdy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyDAOKDY {

    private final StudyMapperKdy studyMapperKdy;

    //    메인 페이지 스터디 리스트 가져오기
    public List<MainStudyDTO> findStudyListByScrapRank(){
        return studyMapperKdy.studyListByScrap();
    }

}
