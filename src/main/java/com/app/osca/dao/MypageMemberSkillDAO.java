package com.app.osca.dao;

import com.app.osca.domain.dto.MemberSkillDTO;
import com.app.osca.mapper.MypageMemberSkillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageMemberSkillDAO {
    private final MypageMemberSkillMapper memberSkillMapper;


    //  멤버 스킬 추가하기
    public void save(Long skillListId, Long memberId){
        memberSkillMapper.insert(skillListId, memberId);
    }

    //  멤버 스킬 가져오기
    public List<MemberSkillDTO> findByMemberId(Long memberId){
        return memberSkillMapper.selectAllByMemberId(memberId);
    }

    //  멤버 스킬 존재 여부
    public int findByMemberIdAndSkillListId(Long skillListId, Long memberId){
        return memberSkillMapper.selectExistsSkill(skillListId, memberId);
    }

    //  멤버 스킬 업데이트
    public void setMemberSkillId(Long skillListId, Long memberId){
        memberSkillMapper.update(skillListId, memberId);
    }

    //  멤버 스킬 삭제하기
    public void deleteMemberSkillId(Long skillListId, Long memberId){
        memberSkillMapper.delete(skillListId, memberId);
    }
}
