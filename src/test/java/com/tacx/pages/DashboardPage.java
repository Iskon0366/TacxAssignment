package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(),'Dashboard')]")
    public WebElement dashboardH2Title;

}
