package com.sillycom.pizzer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "pizza_pizzas")
@NoArgsConstructor
public class Pizza {

  @OneToMany(mappedBy = "pizza", cascade = CascadeType.REMOVE)
  private final Set<RecentlyEated> recentlyEatedSet = new java.util.LinkedHashSet<>();
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Getter
  private String id;

  @Getter
  @Setter
  private String name;

  public Pizza(String name) {
    this.name = name;
  }
}
