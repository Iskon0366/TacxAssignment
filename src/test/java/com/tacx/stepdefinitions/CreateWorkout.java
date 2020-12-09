package com.tacx.stepdefinitions;

import com.tacx.pages.*;
import com.tacx.utilities.BrowserUtils;
import com.tacx.utilities.ConfigurationReader;
import com.tacx.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class CreateWorkout {

    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    DashboardPage dashboardPage = new DashboardPage();
    CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage();
    Create create = new Create();
    WorkoutsPage workoutsPage = new WorkoutsPage();
    String titleCheck="";

    @Given("Launch any browser and navigate to site")
    public void launch_any_browser_and_navigate_to_site() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @Then("Select Create Account option")
    public void select_create_account_option() {

        loginPage.createAccountButton.click();
    }

    @Then("Enter details and click on sign up button to create new Tacx account")
    public void enter_details_and_click_on_sign_up_button_to_create_new_tacx_account() {

        signupPage.firstNameSignupTBox.sendKeys(ConfigurationReader.get("UserName"));
        signupPage.emailSignupTBox.sendKeys(ConfigurationReader.get("UserEmail"));
        signupPage.passwordSignupTBox.sendKeys(ConfigurationReader.get("UserPassword"));
        signupPage.repeatPasswordSignupTBox.sendKeys(ConfigurationReader.get("UserPassword"));
        signupPage.acceptTermsCBox.click();
        signupPage.confirmAgeCBox.click();
        signupPage.signupButton.click();

        BrowserUtils.waitForInvisibility(signupPage.loadingIndicator, 15);
    }

    @Then("Verify the URL in App dashboard")
    public void verify_the_url_in_app_dashboard() {

        Assert.assertEquals("Dashboard", dashboardPage.dashboardH2Title.getText());
        Assert.assertEquals("https://cloud.tacx.com/#/dashboard", Driver.get().getCurrentUrl());

    }

    @Then("Select “Create workout” menu item from left pane in dashboard")
    public void select_create_workout_menu_item_from_left_pane_in_dashboard() {
        dashboardPage.createWorkoutMenuItem.click();

    }

    @Then("Select Power workout and then select distance as target and then select continue")
    public void select_power_workout_and_then_select_distance_as_target_and_then_select_continue() {
        BrowserUtils.waitForClickablility(createWorkoutPage.powerWOType,2);
        createWorkoutPage.powerWOType.click();
        BrowserUtils.waitForClickablility(createWorkoutPage.distanceTargetType,2);
        createWorkoutPage.distanceTargetType.click();
        BrowserUtils.waitForClickablility(createWorkoutPage.continueButton,2);
        createWorkoutPage.continueButton.click();
    }
    @Then("Set distance to {double} KM and save the workout with title name {string}")
    public void setDistanceToKMAndSaveTheWorkoutWithTitleName(double wantedDist, String title) {

        String distanceValueText = create.distanceValue.getText().split(" ")[0];
        System.out.println("distanceValueText = " + distanceValueText);
        double distance = Double.parseDouble(distanceValueText);
        double count = 0;
        if(distance<wantedDist){
            count = wantedDist-distance;
            for (int i=1;i<=count*10;i++){
                create.distanceArrowUp.click();
            }
        }else{
            count = distance-wantedDist;
            for (int i=1;i<=count*10;i++){
                create.distanceArrowDown.click();
            }
        }

        double lastDistance = Double.parseDouble(create.distanceValue.getText().split(" ")[0]);
        Assert.assertEquals(wantedDist,lastDistance,0);
        create.workoutSaveButton.click();
        create.workoutTitleTBox.sendKeys(title, Keys.ENTER);
        titleCheck+=title;
        BrowserUtils.waitFor(2);

    }

    @Then("navigate to “Workouts” menu item and verify the created new Workout with mentioned title name")
    public void navigate_to_workouts_menu_item_and_verify_the_created_new_workout_with_mentioned_title_name() {
        //BrowserUtils.waitForInvisibility(workoutsPage.toastContainer,15);
        BrowserUtils.waitForInvisibility(workoutsPage.svgCircle,10);
        System.out.println("workoutsPage.newWorkoutName.getText() = " + workoutsPage.newWorkoutName.getText());
        Assert.assertEquals(titleCheck,workoutsPage.newWorkoutName.getText());
    }

    @Then("Logout from Account")
    public void logout_from_account() {
        //https://cloud.tacx.com/#/login
        workoutsPage.signOutButton.click();
        Assert.assertEquals("https://cloud.tacx.com/#/login",Driver.get().getCurrentUrl());
    }


}
