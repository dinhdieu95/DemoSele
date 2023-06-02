package pom.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
  public SelenideElement user = Selenide.$x("//div//input[contains(@name, 'loginKey')]");
  public SelenideElement password = Selenide.$x("//div//input[contains(@name, 'password')]");
  public SelenideElement buttonLogin = Selenide.$x("//form/div/div[2]/button");
  public SelenideElement titleFalse = Selenide.$x("//div[contains(@class, 'gCY-Ye')]");
}
