package com.app.osca.controller.findAccount;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class FindAccountControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private void isConnectOk(String URI){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get(URI))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    @Test
    public void goToFindAccount(){
        isConnectOk("/find-account");
    }
}
