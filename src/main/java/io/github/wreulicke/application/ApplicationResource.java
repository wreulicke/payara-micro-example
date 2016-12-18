package io.github.wreulicke.application;

import java.util.List;

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
import io.github.wreulicke.application.auth.TaskRepository;
import io.github.wreulicke.application.exception.InvalidAccessException;
import io.github.wreulicke.application.model.Task;
import io.github.wreulicke.application.model.User;

@RequestScoped
@Path("/example")
public class ApplicationResource {
  @Inject
  UserManager userManager;
  @Inject
  TaskRepository taskRepository;

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
        User result = userManager.authenticate(user)
          .orElseThrow(() -> new InvalidAccessException("cannot login; please check your password or user name"));
        manager.setUser(result);
        return new User().setName(result.getName());
      });
  }
  @GET
  @Path("task")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Task> tasklist(){
    return taskRepository.findAll();
  }
  
  @POST
  @Path("addTask")
  @Produces(MediaType.APPLICATION_JSON)
  public Task addTask(NewTaskRequest task) {
    return taskRepository.add(task);
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
