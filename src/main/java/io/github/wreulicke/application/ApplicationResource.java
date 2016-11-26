package io.github.wreulicke.application;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/example")
public class ApplicationResource {
  @GET
  @Path("hello")
  public String hello() {
    return "test";
  }

  @GET
  @Path("user")
  @Produces(MediaType.APPLICATION_JSON)
  public User get() {
    return new User("xx");
  }

  @GET
  @Path("prisoner")
  @Produces(MediaType.APPLICATION_JSON)
  public Prisoner getPrisoner() {
    return new Prisoner().setName("orekyuu");
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
