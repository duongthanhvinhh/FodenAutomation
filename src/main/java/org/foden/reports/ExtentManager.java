package org.foden.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

/**
 * The type Extent manager.
 */
public final class ExtentManager {

    private ExtentManager(){}
    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    /**
     * Get extent test extent test.
     *
     * @return the extent test
     */
    public static ExtentTest getExtentTest(){
        return extTest.get();
    }

    /**
     * Set extent test.
     *
     * @param test the test
     */
    static void setExtentTest(ExtentTest test){
        if (Objects.nonNull(test)){
            extTest.set(test);
        }
    }

    /**
     * Unload.
     */
    static void unload(){
        extTest.remove();
    }
}
