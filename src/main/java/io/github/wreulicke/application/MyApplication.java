package io.github.wreulicke.application;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.CommonProperties;

@ApplicationPath("/api")
public class MyApplication extends Application {
  private final Map<String, Object> properties;
  public MyApplication() {
    properties=new HashMap<>();
    properties.put(CommonProperties.MOXY_JSON_FEATURE_DISABLE, true);
  }
  
  @Override
  public Map<String, Object> getProperties() {
    return Collections.unmodifiableMap(properties);
  }
}
