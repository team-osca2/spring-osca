package com.app.osca.ceo.mapper;

import com.app.osca.domain.dto.ceo.CeoDTO;
import com.app.osca.mapper.CeoMapper;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CeoMapperTest {

    @Autowired
    private CeoMapper ceoMapper;

    @Test
    public void updatePointTest(){
        CeoDTO ceoDTO = CeoDTO.builder()
                .memberId(3L)
                .ticketPoint(10000L)
                .build();
        assertThat(ceoMapper.updatePoint(ceoDTO)).isEqualTo(1);
    }

    @Test
    public void selectMemberPointTest(){
        assertThat(ceoMapper.selectMemberPoint(2L)).isEqualTo(990000);
    }

}
