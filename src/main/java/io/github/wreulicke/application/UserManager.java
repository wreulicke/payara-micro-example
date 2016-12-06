package io.github.wreulicke.application;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.github.wreulicke.application.auth.User;
import io.github.wreulicke.application.auth.UserRepository;

@ApplicationScoped
public class UserManager {
  @Inject
  UserRepository repository;

  public Optional<User> authenticate(User user) {
    return repository.find(user);
  }

  public User regist(User user) {
    return repository.regist(user);
  }


  @PostConstruct
  public void initialize() {
    User admin = new User().setName("admin")
      .setPassword("admin");
    repository.regist(admin);
    User user = new User().setName("user")
      .setPassword("user");
    repository.regist(user);
  }
}
