package io.github.wreulicke.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@Entity
@NamedQueries({
  @NamedQuery(name="Task.findAll",query="Select task from Task task")
})
public class Task implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private Long parent;

}
