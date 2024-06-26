package org.foden.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.foden.constants.FrameworkConstants;
import org.foden.driver.DriverManager;
import org.foden.enums.ConfigProperties;
import org.foden.utils.PropertyUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver() throws MalformedURLException {

        WebDriver driver = null;
        String browser = PropertyUtils.get(ConfigProperties.BROWSER);
        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
        boolean runOnBrowserStack = true;
        boolean runOnJenkinsChromeBinary = true;
            if (runOnJenkinsChromeBinary){
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("disable-gpu");
                driver = new ChromeDriver(options);
            }else if(runOnBrowserStack){
                String username = System.getenv("BROWSERSTACK_USERNAME");
                String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
                String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
                String local = System.getenv("BROWSERSTACK_LOCAL");
                String localidentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "Chrome");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
                browserstackOptions.put("local", local);
                browserstackOptions.put("localIdentifier",localidentifier);
//                browserstackOptions.put("seleniumVersion", "4.0.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
            } else {
                if (browser.equalsIgnoreCase("chrome")){

                    if (runmode.equalsIgnoreCase("remote")){
                        DesiredCapabilities cap = new DesiredCapabilities();
                        cap.setBrowserName("chrome");
                        ChromeOptions options = new ChromeOptions();
//                    options.setBrowserVersion("124.0");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--no-sandbox");
                        options.addArguments("start-maximized");
                        options.addArguments("disable-infobars");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--headless");
                        options.addArguments("--remote-debugging-pipe");
                        driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
                    }else {
                        WebDriverManager.chromedriver().setup();
//                WebDriverManager.getInstance(DriverManagerType.CHROME);
//                WebDriverManager.chromedriver().proxy("http://username:password@mycompanyproxy.com:port");
                        ChromeOptions options = new ChromeOptions();
                        if (FrameworkConstants.isHeadless()){
                            options.addArguments("--headless");
                        }
                        driver = new ChromeDriver(options);
                    }

                } else if (browser.equalsIgnoreCase("firefox")) {

                    if (runmode.equalsIgnoreCase("remote")){
                        DesiredCapabilities cap = new DesiredCapabilities();
                        cap.setBrowserName("firefox");
                        driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
                    }else {
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions options = new FirefoxOptions();
                        if (FrameworkConstants.isHeadless()){
                            options.addArguments("--headless");
                        }
                        driver = new FirefoxDriver(options);
                    }
                }
            }


            return driver;
    }
}


