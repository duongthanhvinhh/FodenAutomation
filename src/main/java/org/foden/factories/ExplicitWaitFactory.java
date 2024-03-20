package org.foden.factories;

import org.foden.constants.FrameworkConstants;
import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Explicit wait factory.
 */
public class ExplicitWaitFactory {

    private ExplicitWaitFactory(){};

    /**
     * Perform explicit wait web element.
     *
     * @param waitStrategy the wait strategy
     * @param by           the by
     * @return the web element
     */
    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
        WebElement ele = null;
        if (waitStrategy == WaitStrategy.CLICKABLE){
           ele = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by));
        }else if (waitStrategy == WaitStrategy.PRESENCE){
            ele = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by));
        }else if (waitStrategy == WaitStrategy.VISIBLE){
            ele = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by));
        }else if (waitStrategy == WaitStrategy.NONE){
            ele = DriverManager.getDriver().findElement(by);
        }
        return ele;
    }
}
