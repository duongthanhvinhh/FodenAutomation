package org.foden.pages;

import org.foden.enums.WaitStrategy;
import org.foden.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

/**
 * The type Amazon hamburger menu page.
 */
public final class AmazonHamburgerMenuPage extends BasePage{

//    @FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
//    private WebElement linkMobileAndComputers;
//
//    @FindBy(xpath = "//a[text()='Laptops']")
//    private WebElement linkLaptops;
//
//    @FindBy(xpath = "//a[text()='Drives & Storage']")
//    private WebElement linkDrivesAndStorage;
//
//    @FindBy(id = "//a[text()='Printers & Ink']")
//    private WebElement linkPrinterAndInk;

    /**
     * The Link computers.
     */
    String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
    private String linkSubMenu = "//a[text()='%s']";

    /**
     * Click computer amazon hamburger menu page.
     *
     * @return the amazon hamburger menu page
     */
    public AmazonHamburgerMenuPage clickComputer(){
        click(By.xpath(linkComputers),WaitStrategy.CLICKABLE,"Mobiles and Computers");
        return this;
    }

    /**
     * Click on sub menu item amazon laptop page.
     *
     * @param menutext the menutext
     * @return the amazon laptop page
     */
    public AmazonLaptopPage clickOnSubMenuItem(String menutext){
        String newxpath = DynamicXpathUtils.getXpath(linkSubMenu,menutext);
        click(By.xpath(newxpath), WaitStrategy.CLICKABLE,menutext);
        if (menutext.contains("Laptops")){
            return new AmazonLaptopPage();
        }
        return null;
    }

//    public AmazonHamburgerMenuPage(){
//        PageFactory.initElements(DriverManager.getDriver(),this);
//    }
//
//    public AmazonHamburgerMenuPage clickMobilesAndComputers(){
//        linkMobileAndComputers.click();
//        return this;
//    }
//
//    public AmazonLaptopPage clickLaptop(){
//        linkLaptops.click();
//        return new AmazonLaptopPage();
//    }
//
//    public AmazonHamburgerMenuPage clickDrivesAndStorage(){
//        linkDrivesAndStorage.click();
//        return this;
//    }
//
//    public AmazonHamburgerMenuPage clickPrintersAndInk(){
//        linkPrinterAndInk.click();
//        return this;
//    }
}
