Feature: Main site functions
  Try to use main functions on demo-opencart.ru with Selenium on Chrome

  Scenario: Registration is available

    Given open index page
    When click top menu Account - Registration
    Then current url is "http://demo-opencart.ru/index.php?route=account/register"

  Scenario: Change language English/Russian

    Given open index page
    When choose "English" in language selector
    Then current language is "English"
    When choose "Русский" in language selector
    Then current language is "Русский"

  Scenario: Change currency
#    Use ISO 4217 currency codes

    Given open index page
    When choose "EUR" in currency selector
    Then current currency is "EUR"
    When choose "RUB" in currency selector
    Then current currency is "RUB"
    When choose "GBP" in currency selector
    Then current currency is "GBP"
    When choose "USD" in currency selector
    Then current currency is "USD"

  Scenario: Test top menu

    Given open index page
    Then top menu consists of: "Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players"


