package com.app.osca.mapper;

import com.app.osca.domain.dto.StudyScrapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MypageStudyScrapMapper {
//    스크랩한 스터디 가져오기
    public List<StudyScrapDTO> selectByMemberId(Long memberId);

//    스크랩한 스터디 삭제하기
    public void delete(Long Id);

}
