package org.foden.pages;

import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.foden.reports.ExtentLogger;
import org.foden.reports.ExtentManager;
import org.foden.reports.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Orange hrm login page.
 */
public final class OrangeHRMLoginPage extends BasePage{

    private final By txtboxUsername = By.xpath("//input[@name='username']");
    private final By txtboxPassword = By.xpath("//input[@type='password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");

    /**
     * Enter user name orange hrm login page.
     *
     * @param userName the user name
     * @return the orange hrm login page
     */
    public OrangeHRMLoginPage enterUserName(String userName){
        sendKeys(txtboxUsername,userName,WaitStrategy.VISIBLE,"User Name input field");
        return this;
    }

    /**
     * Enter password orange hrm login page.
     *
     * @param password the password
     * @return the orange hrm login page
     */
    public OrangeHRMLoginPage enterPassword(String password){
        sendKeys(txtboxPassword,password,WaitStrategy.NONE,"Password input field");
        return this;
    }

    /**
     * Click login orange hrm home page.
     *
     * @return the orange hrm home page
     */
    public OrangeHRMHomePage clickLogin(){
        click(btnLogin, WaitStrategy.CLICKABLE,"Login button");
        return new OrangeHRMHomePage();
    }

}
