package com.sillycom.pizzer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "pizza_recently_eated")
@NoArgsConstructor
public class RecentlyEated {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Getter
  private String id;

  @OrderColumn(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @Getter
  private Date timestamp;

  @ManyToOne
  @JoinColumn(name = "pizza_id")
  @Getter
  @Setter
  private Pizza pizza;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @Getter
  @Setter
  private User user;

  public RecentlyEated(Pizza pizza, User user) {
    this.pizza = pizza;
    this.user = user;
  }
}