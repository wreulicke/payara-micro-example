package io.github.wreulicke.application;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class EmbeddedApplicationRunner {

  public static void main(String[] args) throws BootstrapException {
    PayaraMicro.getInstance()
        .addDeployment("build/libs/ROOT.war")
        .bootStrap();
  }
}
