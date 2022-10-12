package com.sillycom.pizzer.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest {

  @Getter
  @Setter
  public String email;
}
