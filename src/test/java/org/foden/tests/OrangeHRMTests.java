package org.foden.tests;

import org.assertj.core.api.Assertions;
import org.foden.annotations.FrameworkAnnotation;
import org.foden.enums.CategoryType;
import org.foden.listeners.RetryFailedTests;
import org.foden.pages.OrangeHRMLoginPage;
import org.foden.reports.ExtentReport;
import org.foden.utils.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;

/**
 * The type Orange hrm tests.
 */
public class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests(){}

    /**
     * Login logout test.
     *
     * @param data the data
     */
    @FrameworkAnnotation(author = {"Foden", "VinhDuong"}, category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test
    public void loginLogoutTest(Map<String, String> data){
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickUserProfile().clickLogout().getPageTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    /**
     * New test.
     *
     * @param data the data
     */
    @FrameworkAnnotation(author = {"Foden", "VinhDuong"}, category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test
    public void newTest(Map<String, String> data){
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickUserProfile().clickLogout().getPageTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    /**
     * Get data object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "LoginTestDataProvider",parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin","admin123"},
                {"Admin123","admin1234"}
        };
    }
}
