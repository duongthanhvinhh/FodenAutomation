package org.foden.tests;

import org.foden.constants.FrameworkConstants;
import org.foden.driver.Driver;
import org.foden.enums.ConfigProperties;
import org.foden.utils.PropertyUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * The type Base test.
 */
public class BaseTest {

    /**
     * Instantiates a new Base test.
     */
    protected BaseTest(){}

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @BeforeMethod
    protected void setUp(){
        Driver.initDriver();
    }

    /**
     * Tear down.
     */
    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
