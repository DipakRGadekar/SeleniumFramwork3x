package com.Test.SeleniumFramwork3x.tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.Test.SeleniumFramwork3x.driver.DriverManagerTL;
import com.Test.SeleniumFramwork3x.pages.LoginPage;
import com.Test.SeleniumFramwork3x.testbase.TestBase;
import com.Test.SeleniumFramwork3x.utils.ProperReader;
import com.aventstack.extentreports.ExtentTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends TestBase {
	// Inheritance
	ExtentTest test;
	private static final Logger logger = LogManager.getLogger(LoginTest.class);

	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify the Valid Credentials are working file")
//    @Test(groups = {"P0", "negative", }, priority = 1)
	@Test(groups = { "QA" })
	public void invalid_loginVWO(Method method) throws Exception {
		// Navigate, Login to VWO and Assert
		// Abstraction
		test = createTest(method.getName());
		DriverManagerTL.getDriver().get(ProperReader.readKey("url"));
		String expectResult = new LoginPage().loginToVWO(false).error_message_text();
		logger.info("Failed");

		if (expectResult.equalsIgnoreCase(expectResult)) {
			logger.info("Failed");
			test.fail("Failed Testcases");
			test.addScreenCaptureFromBase64String(captureScreenshot(DriverManagerTL.getDriver()));
			takeScreenShot(method.getName(), DriverManagerTL.getDriver());
		}

		Assertions.assertThat(expectResult).isNotBlank().isNotNull().contains(ProperReader.readKey("expected_error"));

	}

//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Verify the Invalid Credentials are working file")
//    @Test(groups = {"P0", "positive"},priority = 2)
//    public void testLoginPositive() throws Exception {
//        // Navigate, Login to VWO and Assert
//        // Abstraction
//        DriverManagerTL.getDriver().get(ProperReader.readKey("url"));
//        DashboardPage dashboardPage = new LoginPage().loginToVWO(true).afterLogin();
//        String expectResult = dashboardPage.loggedInUserName();
//        Assertions.assertThat(expectResult)
//                .isNotBlank().isNotNull().contains(ProperReader.readKey("expected_username"));
//
//    }

}