package com.app.osca.dao;

import com.app.osca.domain.dto.MemberJobDTO;
import com.app.osca.mapper.MypageMemberJobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MypageMemberJobDAO {
    private final MypageMemberJobMapper memberJobMapper;

//  멤버의 직업 가져오기
    public Optional<MemberJobDTO> findByMemberId(Long memberId){
        return memberJobMapper.selectByMemberId(memberId);
    }
}
