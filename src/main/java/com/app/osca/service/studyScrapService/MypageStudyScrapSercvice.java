package com.app.osca.service.studyScrapService;

import com.app.osca.domain.dto.StudyScrapDTO;

import java.util.List;

public interface MypageStudyScrapSercvice {

    //    스크랩한 스터디 가져오기
    public List<StudyScrapDTO> getScrapList(Long memberId);

    //    스크랩한 스터디 삭제하기
    public void remove(Long id);
}
