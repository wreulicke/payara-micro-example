package io.github.wreulicke.application;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Value;



@Value
@AllArgsConstructor
public class User implements Serializable{
  private static final long serialVersionUID = 1L;
  String name;
}

