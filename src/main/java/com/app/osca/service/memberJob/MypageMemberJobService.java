package com.app.osca.service.memberJob;

import com.app.osca.domain.MemberJobVO;
import com.app.osca.domain.dto.MemberJobDTO;

import java.util.Optional;

public interface MypageMemberJobService {
    //  멤버의 직업 가져오기
    public Optional<MemberJobDTO> getByMemberId(Long memberId);

    //  멤버의 직업 추가하기
    public void write(MemberJobVO memberJobVO);

    //  멤버의 직업 수정하기
    public void modifyJobId(MemberJobVO memberJobVO);
}
