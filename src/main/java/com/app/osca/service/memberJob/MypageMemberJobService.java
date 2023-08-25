package com.app.osca.service.memberJob;

import com.app.osca.domain.dto.MemberJobDTO;

import java.util.Optional;

public interface MypageMemberJobService {
    //  멤버의 직업 가져오기
    public Optional<MemberJobDTO> getByMemberId(Long memberId);
}
