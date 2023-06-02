package com.example.DemoSele;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pom.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
  LoginPage loginPage = new LoginPage();

  @BeforeAll
  public static void setUpAll() {
    Configuration.browserSize = "1280x800";
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @BeforeEach
  public void setUp() {
    open("https://shopee.vn/buyer/login");
  }

  @Test
  public void search() {
    loginPage.user.sendKeys("test");
    loginPage.password.sendKeys("123456");
    loginPage.buttonLogin.click();
    Selenide.screenshot("TestCaptureLogi");
    Selenide.sleep(15000);
    Assert.assertEquals(true, loginPage.titleFalse.isDisplayed());
  }
}
