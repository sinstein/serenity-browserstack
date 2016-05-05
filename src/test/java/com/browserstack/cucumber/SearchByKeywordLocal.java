package com.browserstack.cucumber;

import com.browserstack.local.Local;
import cucumber.api.CucumberOptions;
import java.util.HashMap;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.junit.BeforeClass;
import org.junit.AfterClass;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search/google.feature")
public class SearchByKeywordLocal {
  static Local bsLocal;
  static String browserStackAccessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

  @BeforeClass
  public static void setUp() throws Exception {
    bsLocal = new Local();
    HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
    bsLocalArgs.put("key", browserStackAccessKey);
    bsLocal.start(bsLocalArgs);
  }

  @AfterClass
  public static void tearDown() throws Exception {
    if(bsLocal != null) {
      bsLocal.stop();
    }
  }
}
