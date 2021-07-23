package com.sparta.eng87.finalproject.ControllerTests;

import com.sparta.eng87.finalproject.controllers.TrainerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class TrainerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TrainerController trainer;

    @Test
    void contextLoads() throws Exception{
        assertThat(trainer).isNotNull();
    }

    @Test
    @WithMockUser
    void shouldDirectToAddTrainerPage() throws Exception{
        this.mockMvc.perform(get("/addTrainer")).andDo(print()).andExpect(status().isOk())

                .andExpect(content().string(containsString("addTrainer")));
    }

    @Test
    @WithMockUser
    void shouldDirectToEditTrainerPage() throws Exception{
        this.mockMvc.perform(get("/editTrainer/1")).andDo(print()).andExpect(status().isOk())

                .andExpect(content().string(containsString("Edit a Trainer")));
    }
}
