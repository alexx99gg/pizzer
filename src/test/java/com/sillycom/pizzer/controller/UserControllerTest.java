package com.sillycom.pizzer.controller;

import com.google.gson.Gson;
import com.sillycom.pizzer.PizzerApplication;
import com.sillycom.pizzer.model.request.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PizzerApplication.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UserControllerTest {

  Gson gson = new Gson();
  @Autowired
  private MockMvc mockMvc;

  @Test
  void createUserIntegrationTest() throws Exception {
    CreateUserRequest createUserRequest = new CreateUserRequest("createUserIntegrationTest@silly.com");
    this.mockMvc.perform(post("/user/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gson.toJson(createUserRequest)))
        .andExpect(status().isOk());
  }
}