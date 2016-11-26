package io.github.wreulicke.application;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Deprecated
@Produces(MediaType.APPLICATION_JSON)
public class JacksonBodyWriter implements MessageBodyWriter<User> {
  ObjectMapper mapper=new ObjectMapper();
  @Override
  public long getSize(User user, Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType) {
    return -1;
  }

  @Override
  public boolean isWriteable(Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType) {
    return clazz.isAssignableFrom(User.class);
  }

  @Override
  public void writeTo(User user, Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream)
    throws IOException, WebApplicationException {
    mapper.writeValue(outputStream, user);
  }


}
