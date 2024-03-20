package org.foden.tests;

import static org.assertj.core.api.Assertions.*;

import org.foden.annotations.FrameworkAnnotation;
import org.foden.driver.DriverManager;
import org.foden.enums.CategoryType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * The type Home page tests.
 */
public final class HomePageTests extends BaseTest{

    private HomePageTests(){}

    /**
     * Home test.
     */
    @FrameworkAnnotation(author = {"Foden", "VinhDuong"}, category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test
    public void homeTest(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - YouTube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .as("Object is actually null").isNotNull()
                .as("It does not contains expected text").containsIgnoringCase("tìm trên google")
                .matches("\\w.*" + "Google")
                .hasSizeBetween(15,100);

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        assertThat(elements)
                .hasSizeGreaterThan(0)
                .extracting(WebElement::getText)
                .contains("Testing Mini Bytes");
    }
}
