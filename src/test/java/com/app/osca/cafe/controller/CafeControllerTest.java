package com.app.osca.cafe.controller;

import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CafeControllerTest{
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void goToMyCafeListTest() throws Exception {
        assertThat(
            Objects.requireNonNull(mockMvc.perform(MockMvcRequestBuilders.get("/cafe/my-cafe"))
                    .andReturn()
                    .getModelAndView()
            )
            .getModelMap()
            .get("myCafeList")
        ).isEqualTo("sdf");
    }

    @Test
    public void goToDetailTest() throws Exception {
        long id = 2L;
        assertThat(
                ((CafeAdDetailDTO)
                    Objects.requireNonNull(mockMvc.perform(MockMvcRequestBuilders.get("/cafe/detail/" + id))
                            .andReturn()
                            .getModelAndView()
                    )
                    .getModelMap()
                    .get("cafe")
                ).getCafeId()
        ).isEqualTo(2L);
    }
}
