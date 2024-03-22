package com.Test.SeleniumFramwork3x.pages;

import org.openqa.selenium.By;

import com.Test.SeleniumFramwork3x.base.BasePage;

public class DashboardPage extends BasePage {

    DashboardPage() {
    }

    By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}