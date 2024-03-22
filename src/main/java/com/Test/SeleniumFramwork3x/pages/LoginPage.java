package com.Test.SeleniumFramwork3x.pages;

import com.Test.SeleniumFramwork3x.base.BasePage;
import com.Test.SeleniumFramwork3x.driver.DriverManagerTL;
import com.Test.SeleniumFramwork3x.utils.ProperReader;

import org.openqa.selenium.By;


public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }

    // Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");

    By error_message = By.id("js-notification-box-msg");

    // Page Actions

    public LoginPage loginToVWO(boolean invalid) throws Exception {

        if (!invalid) {
            enterInput(username, ProperReader.readKey("invalid_username"));
        } else {
            enterInput(username, ProperReader.readKey("username"));
        }

        enterInput(password, ProperReader.readKey("password"));
        clickElement(signButton);
        return this;
    }

    public String error_message_text() throws InterruptedException {
        visibilityOfElementLocated(error_message);
        return DriverManagerTL.getDriver().findElement(error_message).getText();
    }

    // Another - Remaing

    public DashboardPage afterLogin() {
        return new DashboardPage();
    }
}