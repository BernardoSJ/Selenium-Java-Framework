package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void startDriver(){
        driver = new DriverManager().initializeDriver();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

}
