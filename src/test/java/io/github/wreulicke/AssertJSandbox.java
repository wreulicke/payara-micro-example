package io.github.wreulicke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AssertJSandbox {
  @Test
  public void test(){
    System.out.println("aaaaaaaa");
    assertThat(false).isEqualTo(true);
  }
}
