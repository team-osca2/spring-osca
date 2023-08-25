package com.app.osca.dao;

import com.app.osca.domain.MemberSkillVO;
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
    public void save(MemberSkillVO memberSkillVO){
        memberSkillMapper.insert(memberSkillVO);
    }

    //  멤버 스킬 가져오기
    public List<MemberSkillDTO> findByMemberId(Long memberId){
        return memberSkillMapper.selectAllByMemberId(memberId);
    }
}
