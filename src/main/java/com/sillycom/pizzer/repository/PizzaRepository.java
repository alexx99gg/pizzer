package com.sillycom.pizzer.repository;

import com.sillycom.pizzer.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, String> {
}
