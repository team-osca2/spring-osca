package com.app.osca.service.general;

import com.app.osca.domain.GeneralVO;
import com.app.osca.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class GeneralServiceYujin {
    @Autowired
    private MypageGeneralService generalService;

    @Test
    public void selectTest() {
        assertThat(generalService.getGeneralInfo(1L).map(GeneralVO::toString));
    }

    @Test
    public void generalInsertTest(){
        GeneralVO generalVO = new GeneralVO();
        generalVO.setMemberId(3L);
        generalVO.setGeneralUniversity("경희대학교");
        generalVO.setGeneralCompany("쿠팡");
        generalVO.setGeneralIntroduction("안녕하세요. 신입 백엔드 개발자 정유진입니다.");
        generalVO.setGeneralCareer("신입");
        generalVO.setGeneralSalary("월 1000만원 이상");
        generalService.write(generalVO);
    }

}
