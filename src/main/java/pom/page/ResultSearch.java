package pom.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class ResultSearch{
  private SelenideElement mainPage = Selenide.element(By.id("main-header"));
  private SelenideElement displayName = Selenide.$x("//main/h1");
  private List<SelenideElement> content = Selenide.elements(By.cssSelector("main > script:nth-child(40)"));
  public boolean checkMainPageDisplay(){
    return mainPage.isDisplayed();
  }

  public boolean checkDisplayName(String content){
    return displayName.getText().contains(content);
  }

  public void setContent(List<SelenideElement> content) {
    this.content = content;
  }

  public List<SelenideElement> getContent() {
    return content;
  }
}
