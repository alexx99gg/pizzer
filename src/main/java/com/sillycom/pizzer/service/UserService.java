package com.sillycom.pizzer.service;

import com.sillycom.pizzer.model.User;
import com.sillycom.pizzer.model.response.UserDTO;
import com.sillycom.pizzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void createUser(String mail) {
    userRepository.save(new User(mail));
  }

  public UserDTO getUserByMail(String mail) {
    User user = userRepository.getReferenceByMail(mail);
    return new UserDTO(user.getId(), user.getMail());
  }


}
