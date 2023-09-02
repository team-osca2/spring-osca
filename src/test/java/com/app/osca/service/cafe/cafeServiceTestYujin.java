package com.app.osca.service.cafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class cafeServiceTestYujin {
    @Autowired
    private MypageCafeService cafeService;

    //  카페 사업자 번호 가져오기
    @Test
    public void selectBusinessNumTest(){
        assertThat(cafeService.getBusinessNum(3L));
    }

    //  카페 사업자 번호 변경하기
    @Test
    public void updateBusinessNumTest(){
        String businessNum = "206-86-29654";
        cafeService.modifyBusinessNum(businessNum,3L);
    }


}
