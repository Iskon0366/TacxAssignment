package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWorkoutPage extends BasePage{

    @FindBy(xpath = "//p[.='Power']/..")
    public WebElement powerWOType;

    @FindBy(xpath = "//p[.='Slope']/..")
    public WebElement slopeWOType;

    @FindBy(xpath = "//p[.='FTP']/..")
    public WebElement ftpWOType;

    @FindBy(xpath = "//p[.='Distance']/..")
    public WebElement distanceTargetType;

    @FindBy(xpath = "//p[.='Time']/..")
    public WebElement timeTargetType;

    @FindBy(css = "section.continue-button>button")
    public WebElement continueButton;

    @FindBy(xpath = "//h2[@class='page-title ng-binding flex']")
    public WebElement h2TitleCreate;

    @FindBy(xpath = "//h2[@class='md-title create-workout-title']")
    public WebElement middleTitleCreateWorkout;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement middleTitleChooseType;

    @FindBy(xpath = "(//h3)[2]")
    public WebElement middleTitleChooseTarget;

}
