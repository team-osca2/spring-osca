package com.app.osca.service.memberSkill;

import com.app.osca.domain.MemberSkillVO;
import com.app.osca.domain.dto.MemberSkillDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class memberSkillServiceTestYujin {
    @Autowired
    private MypageMemberSkillService memberSkillService;

    @Test
    public void insertMemberSkillTest(){
        MemberSkillVO memberSkillVO = new MemberSkillVO();
        memberSkillVO.setMemberId(2L);
        memberSkillVO.setSkillListId(10L);
        memberSkillService.write(memberSkillVO);
    }

    @Test
    public void selectMemberSkillTest(){
        memberSkillService.getList(2L).stream().map(MemberSkillDTO::toString).forEach(log::info);
    }
}
