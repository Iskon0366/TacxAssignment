package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkoutsPage extends BasePage{

    @FindBy(xpath = "(//div[@class='class-text-style ng-binding ng-scope'])[1]")
    public WebElement newWorkoutName;


    @FindBy(css = "#toast-container>div")
    public WebElement toastContainer;

    @FindBy(css = "#workouts-overview-page > div > md-progress-circular")
    public WebElement svgCircle;

}
