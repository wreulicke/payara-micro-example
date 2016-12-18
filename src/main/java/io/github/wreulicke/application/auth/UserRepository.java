package io.github.wreulicke.application.auth;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import io.github.wreulicke.application.exception.InvalidAccessException;
import io.github.wreulicke.application.model.User;

@ApplicationScoped
public class UserRepository {
  @Inject
  EntityManager em;


  @Transactional
  public User regist(User user) {
    if (!findByName(user.getName()).isPresent()) {
      User newUser = new User().setName(user.getName())
        .setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
      em.persist(newUser);
      return user;
    }
    throw new InvalidAccessException("permission denied");
  }

  public Optional<User> find(User user) {
    return findByName(user.getName()).flatMap((findUser) -> {
      if (BCrypt.checkpw(user.getPassword(), findUser.getPassword())) {
        return Optional.of(findUser);
      }
      else {
        return Optional.empty();
      }
    });
  }

  public Optional<User> findByName(String name) {
    try {
      User user = em.createNamedQuery("User.findByName", User.class)
        .setParameter("name", name)
        .getSingleResult();
      return Optional.of(user);
    } catch (Exception e) {
      return Optional.empty();
    }
  }

}
