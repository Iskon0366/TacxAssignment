package com.tacx.pages;

import com.tacx.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public SignupPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameSignupTBox;

    @FindBy(id = "email")
    public WebElement emailSignupTBox;

    @FindBy(id = "password")
    public WebElement passwordSignupTBox;

    @FindBy(id = "repeatPassword")
    public WebElement repeatPasswordSignupTBox;

    @FindBy(xpath = "//md-checkbox[1]/div[1]")
    public WebElement acceptTermsCBox;

    @FindBy(xpath = "//md-checkbox[2]/div[1]")
    public WebElement confirmAgeCBox;

    @FindBy(id = "signup")
    public WebElement signupButton;

    @FindBy(id = "back-link")
    public WebElement returnThePageButton;

    @FindBy(css = "div.loading-indicator")
    public WebElement loadingIndicator;

}
