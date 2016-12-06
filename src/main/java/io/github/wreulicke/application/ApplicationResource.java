package io.github.wreulicke.application;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.wreulicke.application.auth.Authenticated;
import io.github.wreulicke.application.auth.RoleManager;
import io.github.wreulicke.application.auth.User;

@RequestScoped
@Path("/example")
public class ApplicationResource {
  @Inject
  UserManager userManager;

  @Inject
  RoleManager manager;

  @POST
  @Path("regist")
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  public User regist(User user) {
    userManager.regist(user);
    manager.setUser(user);
    return user;
  }


  @POST
  @Path("login")
  @Produces(MediaType.APPLICATION_JSON)
  public User login(User user) {
    return manager.fetch()
      .orElseGet(() -> {
        User result=userManager.authenticate(user)
          .orElseThrow(() -> new InvaliAccessException("cannot login; please check your password or user name"));
        manager.setUser(result);
        return new User().setName(result.getName());
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
}
