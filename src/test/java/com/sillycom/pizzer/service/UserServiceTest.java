package com.sillycom.pizzer.service;

import com.sillycom.pizzer.model.response.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {
  @Autowired
  UserService userService = new UserService();

  @Test
  void createUserTest() {
    Assertions.assertDoesNotThrow(() -> userService.createUser("createUserTest@silly.com"));
  }

  @Test
  void createUserWithSameMailTest() {
    userService.createUser("createUserWithSameMailTest@silly.com");
    Assertions.assertThrows(DataIntegrityViolationException.class ,() -> userService.createUser("createUserWithSameMailTest@silly.com"));
  }

  @Test
  void getUserByMailTest() {

    userService.createUser("userByMailTest@silly.com");
    UserDTO user = userService.getUserByMail("userByMailTest@silly.com");

    Assertions.assertEquals("userByMailTest@silly.com", user.email);
  }
}