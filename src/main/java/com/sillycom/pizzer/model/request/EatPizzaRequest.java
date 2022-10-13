package com.sillycom.pizzer.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EatPizzaRequest {

  private String userId;

  private String pizzaId;
}
