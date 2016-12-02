package io.github.wreulicke.application;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import io.github.wreulicke.application.auth.Authenticated;
import io.github.wreulicke.application.auth.RoleManager;
import io.github.wreulicke.application.auth.User;

@RequestScoped
@Path("/example")
public class ApplicationResource {
  @PersistenceContext(unitName = "RoleUnit")
  EntityManager em;

  @GET
  @Path("regist")
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  public User regist() {
    User user = new User();
    em.persist(user);
    return user;
  }

  @GET
  @Path("hello")
  public String hello() {
    return "test";
  }

  @GET
  @Path("user")
  @Produces(MediaType.APPLICATION_JSON)
  public User get() {
    return new User().setName("xxx");
  }

  @GET
  @Path("prisoner")
  @Produces(MediaType.APPLICATION_JSON)
  public Prisoner getPrisoner() {
    return new Prisoner().setName("orekyuu");
  }

  @Inject
  RoleManager manager;


  @GET
  @Path("login")
  @Produces(MediaType.APPLICATION_JSON)
  public User login() {
    return manager.fetch()
      .orElseGet(() -> {
        // TODO stub
        User user = new User().setName("admin");
        manager.setUser(user);
        return user;
      });
  }

  @GET
  @Path("me")
  @Authenticated
  @Produces(MediaType.APPLICATION_JSON)
  public User getMyInfo() {
    return manager.fetch()
      .get();
  }

  @GET
  @Path("async")
  @Produces(MediaType.APPLICATION_JSON)
  public void asyncTest(@Suspended AsyncResponse response) {
    System.out.println("log1");
    CompletableFuture.runAsync(() -> {
      response.resume(new Test("test"));
    }, executor);
    System.out.println("log2");
  }

  @Resource
  private ManagedExecutorService executor;
}
