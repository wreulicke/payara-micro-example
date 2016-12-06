package io.github.wreulicke.application.auth;

import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;

import lombok.Setter;
import lombok.experimental.Accessors;

@SessionScoped
public class RoleManager implements Serializable {

  private static final long serialVersionUID = 1L;
  @Setter
  @Accessors(chain = true)
  private User user;

  public Optional<User> fetch() {
    return Optional.ofNullable(user);
  }
}
