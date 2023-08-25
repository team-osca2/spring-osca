package com.app.osca.mapper;

import com.app.osca.domain.dto.MemberJobDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MypageMemberJobMapper {
//  멤버의 직업 가져오기
    public Optional<MemberJobDTO> selectByMemberId(Long memberId);

}
