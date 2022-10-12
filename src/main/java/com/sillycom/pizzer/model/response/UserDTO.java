package com.sillycom.pizzer.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

  @Getter
  @Setter
  public String id;

  @Getter
  @Setter
  public String email;

}
