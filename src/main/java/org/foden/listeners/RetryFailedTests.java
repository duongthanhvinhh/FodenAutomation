package org.foden.listeners;

import org.foden.constants.FrameworkConstants;
import org.foden.enums.ConfigProperties;
import org.foden.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * The type Retry failed tests.
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private final boolean retryFailedTests = PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes");
    private final int numberOfRetries = Integer.parseInt(PropertyUtils.get(ConfigProperties.NUMBEROFRETRIES));
    @Override
    public boolean retry(ITestResult iTestResult) {
        if ((count< numberOfRetries)&&retryFailedTests){
            count++;
            return true;
        }
        return false;
    }
}
