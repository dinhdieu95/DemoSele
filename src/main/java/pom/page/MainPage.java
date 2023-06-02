package pom.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class MainPage {
//https://selenide.org/javadoc/current/com/codeborne/selenide/SelenideElement.html
  public SelenideElement searchData = Selenide.$x("//div//input[contains(@data-view-id, 'main_search_form_input')]");
  public SelenideElement searchButton = Selenide.$x("//div//button[contains(@data-view-id, 'main_search_form_button')]");

}
