package io.github.wreulicke;

import java.util.List;

import org.glassfish.jersey.server.model.Resource;
import org.junit.Test;

import io.github.wreulicke.application.ApplicationResource;

public class ResourceTest {
  @Test
  public void test() {
    List<Resource> resources = Resource.from(ApplicationResource.class)
      .getChildResources();
    resources.stream()
      .map(Resource::getResourceMethods)
      .forEach(System.out::println);

  }
}
