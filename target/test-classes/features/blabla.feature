@integration
Feature: Blabla

  @smoke @createNewUserInvalidName @wipUI @maximize
  Scenario: User should not able to create an account with invalid name
    Given Launch any browser and navigate to site
    And Select Create Account option
    And Enter invalid name and others and click on sign up button to create new Tacx account
    Then User should be not create a new account and be given a warning
