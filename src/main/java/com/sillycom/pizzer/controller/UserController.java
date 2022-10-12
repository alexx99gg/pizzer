package com.sillycom.pizzer.controller;

import com.sillycom.pizzer.model.request.CreateUserRequest;
import com.sillycom.pizzer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/createUser")
  public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest createUserRequest) {
    userService.createUser(createUserRequest.email);
    return ResponseEntity.ok().build();
  }
}
