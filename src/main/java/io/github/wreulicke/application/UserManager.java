package io.github.wreulicke.application;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.github.wreulicke.application.auth.UserRepository;
import io.github.wreulicke.application.model.User;

@ApplicationScoped
public class UserManager {
  @Inject
  UserRepository repository;

  public Optional<User> authenticate(User user) {
    return repository.find(user);
  }

  public User register(User user) {
    return repository.register(user);
  }


  @PostConstruct
  public void initialize() {
    User admin = new User().setName("admin")
      .setPassword("admin");
    repository.register(admin);
    User user = new User().setName("user")
      .setPassword("user");
    repository.register(user);
  }
}
