package org.foden.tests;

import org.assertj.core.api.Assertions;
import org.foden.annotations.FrameworkAnnotation;
import org.foden.enums.CategoryType;
import org.foden.pages.AmazonHomePage;
import org.foden.reports.ExtentManager;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;

/**
 * The type Amazon demo test.
 */
public final class AmazonDemoTest extends BaseTest {

    private AmazonDemoTest(){}

    /**
     * Amazon test.
     *
     * @param data the data
     */
    @FrameworkAnnotation(author = {"Foden", "VinhDuong"}, category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test(priority = 1, invocationCount = 1,description = "Test annotation")
    public void amazonTest(Map<String,String> data){ //Foden,VinhDuong,Dane

//        ExtentManager.getExtentTest().assignAuthor("Foden").assignAuthor("VinhDuong")
//                .assignCategory("Smoke").assignCategory("Regression");

        String title = Objects.requireNonNull(new AmazonHomePage().clickHamburger()
                .clickComputer()
                .clickOnSubMenuItem(data.get("menutext"))).getTitle();
        Assertions.assertThat(title).isNotNull();
    }


}
