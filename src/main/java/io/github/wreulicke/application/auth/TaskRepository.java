package io.github.wreulicke.application.auth;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import io.github.wreulicke.application.NewTaskRequest;
import io.github.wreulicke.application.exception.InvalidAccessException;
import io.github.wreulicke.application.model.Task;

@ApplicationScoped
public class TaskRepository {

  @Inject
  EntityManager em;

  @Transactional
  public Task add(NewTaskRequest task) {
    if (task.getParent() != null) {
      return this.find(task.getParent())
        .map((parent) -> add(new Task().setName(task.getName())
          .setParent(parent.getId())))
        .orElseThrow(() -> new InvalidAccessException("invalid access"));
    }
    return add(new Task().setName(task.getName()));
  }

  private Task add(Task task) {
    em.persist(task);
    return task;
  }

  public Optional<Task> find(Long id) {
    return Optional.ofNullable(em.find(Task.class, id));
  }

  public List<Task> findAll() {
    return em.createNamedQuery("Task.findAll", Task.class)
      .getResultList();
  }
}
