# Serenity-BrowserStack
Run a sample Serenity, Cucumber and Maven test on BrowserStack

##Setup

Clone this repo: `git clone https://github.com/UmangSardesai/serenity-browserstack.git`

Note: You need Maven installed.

## Configuration
Add BrowserStack Username and Automate-key to `serenity.properties`
and in `src/test/java/com/browserstack/cucumber/SearchByKeywordLocal.java`

## Run Tests
1. To run tests on BrowserStack, you simply need to point the hub URL to our Selenium hub 'http://hub.browserstack.com/wd/hub' along with your Username and Automate-key. In Serenity, you can do this using `browserstack.url` parameter as follows:
  
  `mvn clean verify -Dbrowserstack.url=http://<username>:<automate-key>@hub.browserstack.com:80/wd/hub`

2. Instead of mentioning the hub url and other browser and OS parameters in command line, you can give them in a `serenity.properties` file and then simply run your tests using the command:

  `mvn clean verify`

- To run sample tests, run `mvn clean verify -Dbrowserstack.url=http://<username>:<automate-key>@hub.browserstack.com:80/wd/hub`
- To run parallel tests, run `mvn clean verify -Dbrowserstack.url=http://<username>:<automate-key>@hub.browserstack.com:80/wd/hub -f pom_parallel.xml`
- To run local tests, run `mvn clean verify -Dbrowserstack.url=http://<username>:<automate-key>@hub.browserstack.com:80/wd/hub -Dbrowserstack.local=true -f pom_local.xml`
  
## Further Reading
- How to configure capabilities in Serenity while running tests on BrowserStack - http://thucydides.info/docs/serenity-staging/#_running_tests_on_browserstack
- Serenity Docs - http://thucydides.info/docs/serenity-staging/
- BrowserStack documentation for Automate - https://www.browserstack.com/automate/java

This sample Serenity-Cucumber example has been taken from Serenity Demo projects [here](https://github.com/serenity-bdd/serenity-demos/tree/master/cucumber-webtests).  

Happy Testing!  
