package com.app.osca.dao;

import com.app.osca.domain.dto.StudyScrapDTO;
import com.app.osca.mapper.MypageStudyScrapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageStudyScrapDAO {
    private final MypageStudyScrapMapper studyScrapMapper;

    //    스크랩한 스터디 가져오기
    public List<StudyScrapDTO> findByMemberId(Long memberId){
        return studyScrapMapper.selectByMemberId(memberId);
    };

    //    스크랩한 스터디 삭제하기
    public void remove(Long id){studyScrapMapper.delete(id);};

}
