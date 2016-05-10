package com.browserstack.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.text.ParseException;
import com.browserstack.cucumber.pages.GooglePage;

public class GoogleSearchSteps {
  GooglePage googlePage;

  @When("^I search Google for \"([^\"]*)\"$")
  public void search_google_for(String searchWord) throws Throwable {
    googlePage.open();
    googlePage.searchForString(searchWord);
  }

  @Then("^the title should contain \"([^\"]*)\"$")
  public void the_title_should_contain_Google(String matchTitle) throws Throwable {
    googlePage.titleShouldMatch(matchTitle);
  }
}


