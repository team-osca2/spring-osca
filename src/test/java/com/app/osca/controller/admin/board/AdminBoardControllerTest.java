package com.app.osca.controller.admin.board;

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
public class AdminBoardControllerTest {

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
    public void getAllBoardsTest(){
        isConnectOk("admin/board");
    }

    @Test
    public void getCafeBoardsTest(){
        isConnectOk("admin/board/cafe");
    }

    @Test
    public void getStudyBoardsTest(){
        isConnectOk("admin/board/study");
    }

    @Test
    public void getDeleteBoardsTest(){
        isConnectOk("admin/board/delete");
    }

    @Test
    public void getReportedBoardsTest(){
        isConnectOk("admin/board/reported");
    }
}
