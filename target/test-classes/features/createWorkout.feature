@integration @wipUI
Feature:Create a workout

  @smoke @createNewUser @maximize
  Scenario:User should able create an account and create a workout
    Given Launch any browser and navigate to site
    And Select Create Account option
    And Enter details and click on sign up button to create new Tacx account
    Then Verify the URL in App dashboard
    And Select “Create workout” menu item from left pane in dashboard
    And Select Power workout and then select distance as target and then select continue
    And Set distance to 12 KM and save the workout with title name "New Workout - 12 km"
    Then navigate to “Workouts” menu item and verify the created new Workout with mentioned title name
    And Logout from Account

  @loginWithSameUser @maximize
  Scenario: User should login  with same credentials and double click on arrows
    Given Launch any browser and navigate to site
    When User enter the same credentials
    Then Verify the URL in App dashboard
    And Select “Create workout” menu item from left pane in dashboard
    And Select Power workout and then select distance as target and then select continue
    And User right click on the arrow up button
    And Set distance to 12 KM and save the workout with title name "New Workout - 12 km"
    Then navigate to “Workouts” menu item and verify the created new Workout with mentioned title name
    And Logout from Account

  @createNewUserInvalidName  @maximize
  Scenario: User should not able to create an account with invalid name
    Given Launch any browser and navigate to site
    And Select Create Account option
    And Enter invalid name and others and click on sign up button to create new Tacx account
    Then User should be not create a new account and be given a warning

