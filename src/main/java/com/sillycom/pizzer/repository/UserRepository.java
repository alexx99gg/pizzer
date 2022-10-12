package com.sillycom.pizzer.repository;

import com.sillycom.pizzer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  User getReferenceByMail(String mail);
}
