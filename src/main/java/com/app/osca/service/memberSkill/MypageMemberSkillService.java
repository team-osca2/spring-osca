package com.app.osca.service.memberSkill;

import com.app.osca.domain.MemberSkillVO;
import com.app.osca.domain.dto.MemberSkillDTO;

import java.util.List;

public interface MypageMemberSkillService {

    //  멤버 스킬 추가하기
    public void write(MemberSkillVO memberSkillVO);

    //  멤버 스킬 가져오기
    public List<MemberSkillDTO> getList(Long memberId);
}
