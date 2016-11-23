package io.github.wreulicke.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/example")
public class Resource {
  @GET
  @Path("hello")
  public String hello(){
    return "test";
  }
  @GET
  @Path("user")
  @Produces(MediaType.APPLICATION_JSON)
  public User get(){
    return new User("xx");
  }
  @GET
  @Path("prisoner")
  @Produces(MediaType.APPLICATION_JSON)
  public Prisoner getPrisoner(){
    return new Prisoner().setName("orekyuu");
  }
}
