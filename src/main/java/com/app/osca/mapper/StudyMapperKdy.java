package com.app.osca.mapper;

import com.app.osca.domain.ImageVO;
import com.app.osca.domain.dto.main.MainStudyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapperKdy {

//    메인 페이지 스터디 리스트 가져오기
    public List<MainStudyDTO> studyListByScrap();

}
