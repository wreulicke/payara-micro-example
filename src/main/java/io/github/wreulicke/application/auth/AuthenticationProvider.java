package io.github.wreulicke.application.auth;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Authenticated
@ApplicationScoped
public class AuthenticationProvider implements ContainerRequestFilter {
  
  @Inject
  RoleManager manager;

  @Override
  public void filter(ContainerRequestContext context) throws IOException {
    System.out.println("filter");
    if (!manager.fetch()
      .isPresent())
      context.abortWith(Response.status(Response.Status.UNAUTHORIZED)
        .entity("not permitted")
        .build());
  }

}
