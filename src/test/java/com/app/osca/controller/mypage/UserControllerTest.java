package com.app.osca.controller.mypage;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

@SpringBootTest
@Slf4j
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void goToMyPageTest() throws Exception {
        String id = "sdf";
        assertThat(
            (Objects.requireNonNull(
                    mockMvc.perform(MockMvcRequestBuilders.get("/user/" + id))
                          .andReturn()
                          .getModelAndView()
                    ).getViewName()
            )
        ).isEqualTo("mypage/profile-page");
    }
}
