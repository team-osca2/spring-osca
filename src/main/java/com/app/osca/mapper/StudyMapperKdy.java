package com.app.osca.mapper;

import com.app.osca.domain.ImageVO;
import com.app.osca.domain.dto.main.MainStudyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapperKdy {

//    이미지 추가
    public void insert(ImageVO imageVO);

    public List<MainStudyDTO> studyListByScrap();

}
