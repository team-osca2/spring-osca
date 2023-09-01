package com.app.osca.mapper;

import com.app.osca.domain.dto.MemberSkillDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMemberSkillMapper {
//  멤버 스킬 추가하기
    public void insert(Long skillListId, Long memberId);

//  멤버 스킬 가져오기
    public List<MemberSkillDTO> selectAllByMemberId(Long memberID);

//  멤버 스킬 존재여부
    public int selectExistsSkill(Long skillListId, Long memberId);

//  멤버 스킬 업데이트
    public void update(Long skillListId, Long memberId);

    public void delete(Long skillListId, Long memberId);
}

