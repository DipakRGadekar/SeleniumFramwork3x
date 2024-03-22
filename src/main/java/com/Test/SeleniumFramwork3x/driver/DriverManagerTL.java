package com.Test.SeleniumFramwork3x.driver;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManagerTL {
	 // Thread Local - Java

    static WebDriver driver;
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload(){
        dr.remove();
    }

    @BeforeMethod
    public static void init() throws MalformedURLException {
        if(getDriver() == null){
            // TODO #1 - Need to make it support for Firefox, Edge, Safari, and IE

            ChromeOptions options = new ChromeOptions();
            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                /* How to add test badge */
                put("name", "Test badge...");

                /* How to set session timeout */
                put("sessionTimeout", "15m");

                /* How to set timezone */
                put("env", new ArrayList<String>() {{
                    add("TZ=UTC");
                }});

                /* How to add "trash" button */
                put("labels", new HashMap<String, Object>() {{
                    put("manual", "true");
                }});

                /* How to enable video recording */
                put("enableVideo", true);
            }});
      
            setDriver(driver);
        }
    }


    @AfterMethod
    public static void down(){
        if(getDriver()!= null){
            getDriver().quit();
        }
    }
}
