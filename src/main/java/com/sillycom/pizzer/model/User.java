package com.sillycom.pizzer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "pizza_users")
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Getter
  private String id;

  @Column(unique = true, nullable = false)
  @Getter
  @Setter
  private String mail;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  @Getter
  private final Set<RecentlyEated> recentlyEatedSet = new java.util.LinkedHashSet<>();

  public User(String mail) {
    this.mail = mail;
  }
}
