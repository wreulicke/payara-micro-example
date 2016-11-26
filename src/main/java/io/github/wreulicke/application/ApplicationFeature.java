package io.github.wreulicke.application;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.jackson.JacksonFeature;

@Provider
public class ApplicationFeature implements Feature {

  @Override
  public boolean configure(FeatureContext ctx) {
    ctx.register(JacksonFeature.class);
    return true;
  }

}
