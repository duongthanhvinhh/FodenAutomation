package org.foden.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * The type Base ui.
 */
public class BaseUI {
    private WebDriver driver;
    private BaseUI(){}

    /**
     * Wait for page content loaded.
     */
    public void waitForPageContentLoaded(){
        try {
            By loader = By.xpath("//div[@class='loader' or @class='loading' or @class='circle' or @class='spinner' or ./*[name()='svg' and @data-icon='spinner']] | //button//*[name()='svg' and contains(@class, 'fa-spin')]");
            waitForElementUnload(loader);
        } catch (Exception e){
            System.out.println("An error occured when loading content page " + e.getMessage());
        }
    }

    /**
     * Wait for element unload.
     *
     * @param locator the locator
     */
    public void waitForElementUnload(By locator){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.numberOfElementsToBe(locator,0));
            System.out.printf("All element with locator " + locator + " have disappeared");
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
}
