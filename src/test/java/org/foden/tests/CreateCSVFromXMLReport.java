package org.foden.tests;

import org.foden.annotations.FrameworkAnnotation;
import org.foden.driver.DriverManager;
import org.foden.enums.CategoryType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Create csv from xml report.
 */
public class CreateCSVFromXMLReport extends BaseTest{

    /**
     * Create csv result.
     */
    @FrameworkAnnotation(author = {"Foden", "VinhDuong"}, category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test
    public static void createCSVResult(){

        HashMap<String, Boolean> result = new HashMap<String, Boolean>();
        List<WebElement> testcasesEle = DriverManager.getDriver().findElements(By.xpath("//div[text()='Suite']/following-sibling::div/child::span"));
        List<WebElement> statusesEle = DriverManager.getDriver().findElements(By.xpath("//div[@role='rowheader']/following-sibling::div/child::div"));

        ArrayList<String> testcases = new ArrayList<>();
        for (WebElement ele : testcasesEle){
            testcases.add(ele.getText());
        }
        for (String testcase : testcases){
            System.out.println(testcase);
        }
    }

}
