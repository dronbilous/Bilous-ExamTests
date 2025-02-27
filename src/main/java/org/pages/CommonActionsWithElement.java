package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonActionsWithElement {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait_5;
    private Logger logger = Logger.getLogger(getClass());

    public CommonActionsWithElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //ініціалізує елементи описані FindBy
        webDriverWait_5 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

//    ************************************************** Methods **************************************************
    protected void clearAndEnterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            System.out.println(text + " was inputted into element " + getElementName(webElement));
        } catch (Exception e) {
            System.out.println("Cannot work with element " + webElement);
        }
    }
    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_5.until(ExpectedConditions.elementToBeClickable(webElement));
            String elementName = getElementName(webElement);
            webElement.click();
            logger.info(elementName + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }









//    ************************************************** private methods **************************************************
    private String getElementName(WebElement webElement) {
        String elementName;
        try {
            elementName = webElement.getAccessibleName();
        } catch (Exception e) {
            elementName = "";
        }
        return elementName;
    }
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
