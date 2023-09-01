package com.app.osca.service.memberSkill;

import com.app.osca.dao.MypageMemberSkillDAO;
import com.app.osca.domain.dto.MemberSkillDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageMemberSkillServiceImpl implements MypageMemberSkillService {
    private final MypageMemberSkillDAO memberSkillDAO;

    @Override
    @Transactional
    public void write(Long skillListId, Long memberId) {
        memberSkillDAO.save(skillListId,memberId);
    }

    @Override
    public List<MemberSkillDTO> getList(Long memberId) {
        return memberSkillDAO.findByMemberId(memberId);
    }

    @Override
    public int getByMemberIdAndSkillListId(Long skillListId, Long memberId) {
        return memberSkillDAO.findByMemberIdAndSkillListId(skillListId, memberId);
    }

    @Override
    public void modifyMemberSkillId(Long skillListId, Long memberId) {
        memberSkillDAO.setMemberSkillId(skillListId, memberId);
    }

    @Override
    public void removeMemberSkillId(Long skillListId, Long memberId) {
        memberSkillDAO.deleteMemberSkillId(skillListId,memberId);
    }
}

