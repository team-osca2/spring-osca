package com.app.osca.mapper;

import com.app.osca.domain.ImageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberImageMapperKDY {

    public Optional<ImageVO> selectMemberProfileImage(Long id);

}
