package io.github.wreulicke.application;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Prisoner {
  private String name;
}
