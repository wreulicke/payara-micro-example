package io.github.wreulicke.application;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(chain=true)
public class NewTaskRequest {
  private String name;
  private Long parent;
}
