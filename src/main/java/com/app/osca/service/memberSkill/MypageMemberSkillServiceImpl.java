package com.app.osca.service.memberSkill;

import com.app.osca.dao.MypageMemberSkillDAO;
import com.app.osca.domain.MemberSkillVO;
import com.app.osca.domain.dto.MemberSkillDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageMemberSkillServiceImpl implements MypageMemberSkillService {
    private final MypageMemberSkillDAO memberSkillDAO;
    @Override
    public void write(MemberSkillVO memberSkillVO) {
        memberSkillDAO.save(memberSkillVO);
    }

    @Override
    public List<MemberSkillDTO> getList(Long memberId) {
        return memberSkillDAO.findByMemberId(memberId);
    }
}
