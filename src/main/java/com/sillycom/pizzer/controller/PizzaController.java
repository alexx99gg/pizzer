package com.sillycom.pizzer.controller;

import com.sillycom.pizzer.model.request.CreatePizzaRequest;
import com.sillycom.pizzer.model.request.EatPizzaRequest;
import com.sillycom.pizzer.model.response.PizzaDTO;
import com.sillycom.pizzer.service.PizzaService;
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
@RequestMapping(path = "/pizza", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class PizzaController {
  @Autowired
  private PizzaService pizzaService;

  @PostMapping("/create")
  public ResponseEntity<PizzaDTO> createPizza(@RequestBody CreatePizzaRequest createPizzaRequest) {
    PizzaDTO pizzaDTO = pizzaService.createPizza(createPizzaRequest.getName());
    return ResponseEntity.ok().body(pizzaDTO);
  }

  @PostMapping("/eat")
  public ResponseEntity<Void> eatPizza(@RequestBody EatPizzaRequest eatPizzaRequest) {
    pizzaService.eatPizza(eatPizzaRequest.getUserId(), eatPizzaRequest.getPizzaId());
    return ResponseEntity.ok().build();
  }

}
