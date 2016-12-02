package io.github.wreulicke;

import static org.assertj.core.api.Assertions.assertThat;

import java.beans.ConstructorProperties;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.wreulicke.application.auth.User;

public class AssertJSandbox {
  @Test
  public void jacksonTest() throws JsonParseException, JsonMappingException, IOException{
    ObjectMapper mapper = new ObjectMapper();
    TestBean bean=mapper.readValue("{\"x\":2,\"y\":3}", TestBean.class);

    assertThat(bean.v1).isEqualTo(2);
    assertThat(bean.v2).isEqualTo(3);
    System.out.println(bean.v1+" "+bean.v2);
    User user=mapper.readValue("{\"name\":\"sss\"}", User.class);
    assertThat(user.getName()).isEqualTo("sss");
  }
  static class TestBean {
    private int v1, v2;

    @ConstructorProperties({"x", "y"})
    public TestBean(int a, int b) {
        v1 = a;
        v2 = b;
    }
}
}
