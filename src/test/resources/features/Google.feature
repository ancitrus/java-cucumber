Feature: Test Selenium on Google
  Let's see how we can browse Google with Selenium on Chrome

  Scenario: Search Selenium on Google

    Given open Google main page
    When search "Selenium"
    Then "Selenium" word presents on landing page
    And "https://www.selenium.dev" link is present
