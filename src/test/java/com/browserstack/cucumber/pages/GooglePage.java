package com.browserstack.cucumber.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;


@DefaultUrl("https://www.google.com")
public class GooglePage extends PageObject {

  @FindBy(name="btnG")
  WebElementFacade searchButton;

  private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'%s')]";

  public void enterSearchTerms(String keyword) {
    $("//*[@id=\"lst-ib\"]").type(keyword);
    withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.name("btnG"));
    search();
    waitForKeywordToBeUpdatedTo(keyword);
  }

  private void waitForKeywordToBeUpdatedTo(String keyword) {
    waitForCondition()
      .withTimeout(5, TimeUnit.SECONDS)
      .pollingEvery(250,TimeUnit.MILLISECONDS)
      .until(keywordFieldIsUpdatedTo(keyword));
  }

  private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
    return webDriver -> $("//*[@id=\"lst-ib\"]").getValue().equalsIgnoreCase(keyword);
  }

  public void search() {
    searchButton.click();
  }

  public void searchForString(String searchString) {
    enterSearchTerms(searchString);
  }

  public void titleShouldMatch(String matchTitle) {
    assertThat(this.getTitle()).containsIgnoringCase(matchTitle);
  }
}
