package org.foden.pages;

import org.foden.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The type Amazon home page.
 */
public final class AmazonHomePage extends BasePage{

    @FindBy(id = "nav-hamburger-menu")
    private WebElement linkHamburger;

    /**
     * Instantiates a new Amazon home page.
     */
    public AmazonHomePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    /**
     * Click hamburger amazon hamburger menu page.
     *
     * @return the amazon hamburger menu page
     */
    public AmazonHamburgerMenuPage clickHamburger(){
        linkHamburger.click();
        return new AmazonHamburgerMenuPage();
    }
}
