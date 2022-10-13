package com.sillycom.pizzer.service;

import com.sillycom.pizzer.model.Pizza;
import com.sillycom.pizzer.model.RecentlyEated;
import com.sillycom.pizzer.model.User;
import com.sillycom.pizzer.model.response.PizzaDTO;
import com.sillycom.pizzer.repository.PizzaRepository;
import com.sillycom.pizzer.repository.RecentlyEatedRepository;
import com.sillycom.pizzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PizzaService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PizzaRepository pizzaRepository;

  @Autowired
  private RecentlyEatedRepository recentlyEatedRepository;

  public PizzaDTO createPizza(String name) {
    Pizza pizza = new Pizza(name);
    pizzaRepository.save(pizza);
    return new PizzaDTO(pizza.getId(), pizza.getName());
  }

  public void eatPizza(String userId, String pizzaId) {
    User user = userRepository.getReferenceById(userId);
    Pizza pizza = pizzaRepository.getReferenceById(pizzaId);

    recentlyEatedRepository.save(new RecentlyEated(pizza, user));
  }

  public List<Pizza> getRecentlyEatedPizzas(String userId) {
    User user = userRepository.getReferenceById(userId);

    Set<RecentlyEated> recentlyEatedSet = user.getRecentlyEatedSet();

    List<RecentlyEated> list = new ArrayList<>(recentlyEatedSet);

    list.sort(Comparator.comparing(RecentlyEated::getTimestamp));

    return list.stream().map(RecentlyEated::getPizza).collect(Collectors.toList());
  }
}
