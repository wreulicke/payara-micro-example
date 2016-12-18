package io.github.wreulicke.application;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ApplicationProvider {
  @Produces
  @PersistenceContext(unitName = "SampleUnit")
  EntityManager em;
}
