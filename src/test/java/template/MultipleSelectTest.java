package template;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

final class MultipleSelectTest extends ITest {
  private final SelenideElement select = $("#character");

  @BeforeEach
  void openTestPage() {
    openFile("page_with_multiple_select.html");
  }

  @Test
  void userCanSelectMultipleOptionsByText() {
    select.selectOption("Маргарита", "Theodor Woland");

    select.getSelectedOptions().shouldHave(
        texts("Маргарита", "Theodor Woland"));
  }

  @Test
  void reportsElementNotFound_ifThereIsNoSelectedOptions() {
    assertThatThrownBy(() -> select.getSelectedOptions().shouldHave(texts("Кот", "Бегемот")))
        .isInstanceOf(ElementNotFound.class)
        .hasMessageStartingWith("Element not found {#character selected options}");
  }

  @Test
  void canGiveHumanReadableNameToSelectedOptions() {
    ElementsCollection namedCollection = select.getSelectedOptions().as("my animals");

    assertThatThrownBy(() -> namedCollection.shouldHave(texts("Кот", "Бегемот")))
        .isInstanceOf(ElementNotFound.class)
        .hasMessageStartingWith("Element \"my animals\" not found {#character selected options}");
  }

  @Test
  void userCanSelectMultipleOptionsByIndex() {
    select.selectOption(0, 2, 3);

    select.getSelectedOptions().shouldHave(texts("Мастер", "Кот \"Бегемот\"", "Theodor Woland"));
    select.getSelectedOptions().get(0).shouldHave(text("Мастер"));
    select.getSelectedOptions().get(1).shouldHave(text("Кот \"Бегемот\""));
    select.getSelectedOptions().get(2).shouldHave(text("Theodor Woland"));
  }

  @Test
  void userCanSelectMultipleOptionsByValue() {
    select.selectOptionByValue("cat", "woland");

    select.getSelectedOptions().shouldHave(
        size(2),
        texts("Кот \"Бегемот\"", "Theodor Woland"));
  }

  @Test
  void userCanUseSetSelectedOnOptions() {
    select.$("option[value=cat]").setSelected(true);

    select.getSelectedOptions().shouldHave(
        size(1),
        texts("Кот \"Бегемот\""));

    select.$("option[value=cat]").setSelected(false);

    select.getSelectedOptions().shouldHave(size(0));
  }

  @Test
  void getSelectedOptions_isLazyLoaded() {
    $("#button-select-people").click(); // selects options after 500 ms
    select.getSelectedOptions().shouldHave(
//      exactTextsCaseSensitive("Мастер", "Маргарита"), ofSeconds(1)
    );
  }

  @Test
  void getSelectedOptions_isLazyLoaded2() {
    SelenideElement select = $("#cars"); // initially empty, options are loaded after 600 ms.
    select.getSelectedOptions().shouldHave(
//      exactTextsCaseSensitive("Toyota", "Mazda"), ofSeconds(1)
    );

    $("#button-select-german-cars").click(); // selects options after 600 ms
    select.getSelectedOptions().shouldHave(
//      exactTextsCaseSensitive("Mercedes", "BMW", "Audi"), ofSeconds(1)
    );
  }
}
