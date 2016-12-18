package io.github.wreulicke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class EncryptTest {

  @Test
  public void test() {
    String hash = BCrypt.hashpw("test", BCrypt.gensalt());
    assertThat(BCrypt.checkpw("test", hash)).isEqualTo(true);
  }
}
