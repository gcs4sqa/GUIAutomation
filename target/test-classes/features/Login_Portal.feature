@login-portal

Feature: WebDriver university - Login-Portal page

  Background:
    Given I access the webdriver university login-portal page

  Scenario Outline: Validate successful and unsucessful login
    When I enter a Username of <username>
    And I enter a Password of <password>
    And I press the login button
    Then I should be presented with a login popup of <loginValidationText>
    And I press the OK button on the alert box

    Examples:
      | username  | password     | loginValidationText  |
      | webdriver | webdriver123 | validation succeeded |
      | webdriver | password     | validation failed    |




