@wip
Feature:Create a workout
  Scenario:User should able create an account and create a workout
  Given Launch any browser and navigate to site
  Then Select Create Account option
  And Enter details and click on sign up button to create new Tacx account
  Then Verify the URL in App dashboard
  And Select “Create workout” menu item from left pane in dashboard
  Then Select Power workout and then select distance as target and then select continue
  Then Set distance to 12 KM and save the workout with title name "New Workout - 12 km"
  Then navigate to “Workouts” menu item and verify the created new Workout with mentioned title name
  And Logout from Account