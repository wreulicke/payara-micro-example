package io.github.wreulicke.application.auth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(chain = true)
@Entity
@NamedQueries({
  @NamedQuery(name="User.findByName",query="Select user from User user where user.name=:name")
})
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  @Column(unique = true)
  String name;
  String password;
}

