package com.app.osca.mapper;

import com.app.osca.domain.MemberSkillVO;
import com.app.osca.domain.dto.MemberSkillDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberSkillMapper {
//  멤버 스킬 추가하기
    public void insert(MemberSkillVO memberSkillVO);

//  멤버 스킬 가져오기
    public List<MemberSkillDTO> selectAllByMemberId(Long memberID);
    
}

