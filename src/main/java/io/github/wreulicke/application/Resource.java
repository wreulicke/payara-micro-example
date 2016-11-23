package io.github.wreulicke.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/example")
public class Resource {
  @GET
  public String hello(){
    return "test";
  }
}
