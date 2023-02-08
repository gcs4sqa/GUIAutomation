@contact-us

Feature: WebDriver university - contact Us page

  Background:
    Given I access the webdriver university contact us page

  Scenario Outline: validate submission of all data approaches
    When I enter a first name of <firstname>
    And I enter a last name of <lastname>
    And I enter an email address of <email>
    And I enter a comment of <comment>
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

    Examples:
      | firstname | lastname | email                     | comment            |
      | unique    | unique   | unique                    | unique             |
      | Joe       | Blogs    | joe_blogs123@mail.com     | how are you        |
      | cliff     | Douglas  | cliff.douglas123@mail.com | have a loverly day |
