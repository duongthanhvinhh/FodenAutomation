package org.foden.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.foden.constants.FrameworkConstants;
import org.foden.enums.ConfigProperties;
import org.foden.exceptions.BrowserInvocationFailedException;
import org.foden.factories.DriverFactory;
import org.foden.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * March 04, 2024
 *
 * @author Foden Automation
 * @version 1.0
 * @see DriverManager
 * @since 1.0
 */



public final class Driver {
    /**
     *
     * Private constructor to avoid external instantiation
     *
     */
    private Driver(){}

    /**
     * Quit driver.
     */
//    public static void initDriver() throws Exception {
//        if (Objects.isNull(DriverManager.getDriver())){
//            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
//            DriverManager.setDriver(new ChromeDriver());
//            DriverManager.getDriver().manage().window().maximize();
//            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
//        }
//    }
//
    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

    /**
     * Init driver.
     */
    public static void initDriver(){
        if (Objects.isNull(DriverManager.getDriver())){
            try {
                DriverManager.setDriver(DriverFactory.getDriver());
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Browser invocation failed. Please check the capabilities of browser");
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }
}
/**
 * To run on docker
 * WebDriverManager.chromedriver().setup();
 * DesiredCapabilities cap = new DesiredCapabilities();
 * cap.setBrowserName(BrowserType.CHROME);
 * WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
 */