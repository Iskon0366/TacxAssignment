package com.tacx.pages;

import com.tacx.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//ng-md-icon[@icon='create']/../../..")
    public WebElement createWorkoutMenuItem;

    @FindBy(xpath = "//div[@ng-click='logout()']")
    public WebElement signOutButton;

    @FindBy(xpath = "//div[@ui-sref='profile']")
    public WebElement manageProfileButton;

}
