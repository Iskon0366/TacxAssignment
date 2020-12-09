package com.tacx.pages;

import com.tacx.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "create-account")
    public WebElement createAccountButton;

    @FindBy(id = "reset-password")
    public WebElement resetPasswordButton;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement emailLoginBox;

    @FindBy(id = "password")
    public WebElement passwordLoginBox;

}
