package io.github.wreulicke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Text;

import lombok.val;

public class EncryptTest {

  @Test
  public void test() {
    String hash = BCrypt.hashpw("test", BCrypt.gensalt());
    assertThat(BCrypt.checkpw("test", hash)).isEqualTo(true);
  }

  @Test
  public void login() {
    Configuration.browser = WebDriverRunner.CHROME;
    Selenide.open("http://localhost:8080");
    Selenide.$(By.name("name"))
      .val("admin");
    Selenide.$(By.name("password"))
      .val("admin");
    Selenide.$("button")
      .click();
    Selenide.$("#result")
      .shouldBe(Text.exactText("hello admin!!"));
  }

  @Test
  public void addTask() {
    login();
    val add = Selenide.$(By.cssSelector(".add:last-child"));
    add.click();
    add.$("input")
      .val("xxxx")
      .pressEnter();
    Selenide.$$(".item.tree").last()
      .should(Text.text("xxxx"));
  }
}
