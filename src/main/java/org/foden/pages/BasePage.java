package org.foden.pages;

import org.foden.constants.FrameworkConstants;
import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.foden.factories.ExplicitWaitFactory;
import org.foden.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Base page.
 */
public class BasePage {

    /**
     * Click.
     *
     * @param by           the by
     * @param waitStrategy the wait strategy
     * @param eleName      the ele name
     */
    protected void click(By by, WaitStrategy waitStrategy, String eleName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
            ExtentLogger.pass(eleName + " is clicked");
    }

    /**
     * Send keys.
     *
     * @param by           the by
     * @param value        the value
     * @param waitStrategy the wait strategy
     * @param eleName      the ele name
     */
    protected void sendKeys(By by,String value,WaitStrategy waitStrategy, String eleName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " + eleName);
    }

    /**
     * Get page title string.
     *
     * @return the string
     */
    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
