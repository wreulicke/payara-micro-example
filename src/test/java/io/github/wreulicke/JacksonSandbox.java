package io.github.wreulicke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;

import io.github.wreulicke.application.auth.User;

public class JacksonSandbox {
  private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
  private static final JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);

  @Test
  public void schemaPrint() throws JsonProcessingException {
    JsonSchema schema = generator.generateSchema(User.class);
    System.out.println(mapper.writeValueAsString(schema));

  }

  @Test
  public void case1() throws JsonProcessingException {
    JsonSchema schema = generator.generateSchema(User.class);
    assertThat(schema).isInstanceOf(ObjectSchema.class);
  }
}
