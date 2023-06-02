package com.example.DemoSele;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pom.page.MainPage;
import pom.page.ResultSearch;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.prompt;
import static config.ConfigEnv.PAGE;

public class ConfigTest {
  //  private static MainPage mainPage = new MainPage();
  private static final String contents = "Sách";


  @BeforeAll
  public static void setUp() {
    MainPage mainPage = new MainPage();
    WebDriverManager.firefoxdriver().setup();
    open(PAGE);
    Selenide.sleep(1500);
//    đẩy thông tin lên trang web
    mainPage.searchData.sendKeys(contents);
//    ấn nút
    mainPage.searchButton.click();
  }

  @Test
  @Order(1)
  public void search() {

    Selenide.screenshot("TestCapture");
//    chờ đợi page load
    Selenide.sleep(10000);
    //  validate
    ResultSearch result = new ResultSearch();
//    kiểm tra trang web hiển thị
    Assert.assertTrue(result.checkMainPageDisplay());


  }
}
