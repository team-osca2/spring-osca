package com.app.osca.service.memberSkill;

import com.app.osca.domain.MemberSkillVO;
import com.app.osca.domain.dto.MemberSkillDTO;

import java.util.List;

public interface MypageMemberSkillService {

    //  멤버 스킬 추가하기
    public void write(Long skillListId, Long memberId);

    //  멤버 스킬 가져오기
    public List<MemberSkillDTO> getList(Long memberId);

    //  멤버 스킬 존재 여부
    public int getByMemberIdAndSkillListId(Long skillListId, Long memberId);

    //  멤버 스킬 업데이트
    public void modifyMemberSkillId(Long skillListId, Long memberId);

    //  멤버 스킬 삭제하기
    public void removeMemberSkillId(Long skillListId, Long memberId);
}
