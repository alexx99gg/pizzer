package com.sillycom.pizzer.controller;

import com.google.gson.Gson;
import com.sillycom.pizzer.PizzerApplication;
import com.sillycom.pizzer.model.request.CreatePizzaRequest;
import com.sillycom.pizzer.model.request.CreateUserRequest;
import com.sillycom.pizzer.model.response.UserDTO;
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
class PizzaControllerTest {

  Gson gson = new Gson();
  @Autowired
  private MockMvc mockMvc;

  @Test
  void createPizzaIntegrationTest() throws Exception {
    CreatePizzaRequest createPizzaRequest = new CreatePizzaRequest("Carbonara");
    this.mockMvc.perform(post("/pizza/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gson.toJson(createPizzaRequest)))
        .andExpect(status().isOk());
  }

  @Test
  void eatPizzaIntegrationTest() throws Exception {

    CreateUserRequest createUserRequest = new CreateUserRequest("eatPizzaIntegrationTest@silly.com");
    String createUserJsonResult = this.mockMvc
        .perform(post("/user/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gson.toJson(createUserRequest)))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse().getContentAsString();

    UserDTO userDTO = gson.fromJson(createUserJsonResult, UserDTO.class);


    CreatePizzaRequest createPizzaRequest = new CreatePizzaRequest("Carbonara");
    this.mockMvc.perform(post("/pizza/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gson.toJson(createPizzaRequest)))
        .andExpect(status().isOk());
  }
}