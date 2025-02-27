package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

//    ************************************************ find elements *********************************************
    @FindBy(xpath = "//a[@href='https://knigorai.com/login']")
    private WebElement enterButton;

//    ************************************************ Constructor ****************************************************
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
//    ***********************************************  Methods  *******************************************************

    public LoginPage clickOnEnterButton() {
        clickOnElement(enterButton);
        return new LoginPage(webDriver);
    }
    public HomePage openHomePage() {
        webDriver.get(baseUrl);
        logger.info("Home Page was opened with url " + baseUrl);
        return this;
    }

}
