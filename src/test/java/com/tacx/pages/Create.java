package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Create extends BasePage{

    @FindBy(xpath = "//ng-md-icon[@icon='keyboard_arrow_up'][1]")
    public WebElement distanceArrowUp;

    @FindBy(xpath = "(//span[@class='value ng-binding'])[2]")
    public WebElement distanceValue;

    @FindBy(css = "#duration-group [type='button']:nth-of-type(2) svg")
    public WebElement distanceArrowDown;

    @FindBy(xpath = "//button[text()='save']")
    public WebElement workoutSaveButton;

    @FindBy(xpath = "//md-input-container//input")
    public WebElement workoutTitleTBox;

    @FindBy(xpath = "//button[@ng-click='vm.confirmDialog()']")
    public WebElement dialogBoxSaveButton; //I click with Enter




}
