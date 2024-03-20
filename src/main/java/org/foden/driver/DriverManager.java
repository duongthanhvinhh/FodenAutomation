package org.foden.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * The type Driver manager.
 */
public final class DriverManager {
    private DriverManager(){}

    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    /**
     * Get driver web driver.
     *
     * @return the web driver
     */
    public static WebDriver getDriver(){
        return tdriver.get();
    }

    /**
     * Set driver.
     *
     * @param driver the driver
     */
     static void setDriver(WebDriver driver){
        if (Objects.nonNull(driver)){
            tdriver.set(driver);
        }
    }

    /**
     * Unload.
     */
    public static void unload(){
        tdriver.remove();
    }
}
