package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    protected void clickOnElement(String locator) {
        try {
            WebElement element = webDriver.findElement(By.xpath(locator));
            webDriverWait_5.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element with locator " + locator + " was clicked");
        } catch (Exception e) {
            logger.error("Cannot work with element with locator " + locator);
            printErrorAndStopTest(e);
        }
    }
    protected void checkIsElementVisible(WebElement webElement) {
        Assert.assertTrue("Element is not visible", isElementVisible(webElement));
    }
    protected void checkIsElementVisible(String locator) {
        Assert.assertTrue("Element is not visible with locator " + locator, isElementVisible(locator));
    }

    protected void checkIsElementNotVisible(WebElement webElement) {
        Assert.assertFalse("Element is visible", isElementVisible(webElement));
    }
    // checkTextInElement
    protected void checkTextInElement(WebElement webElement, String text) {
        Assert.assertEquals("Text in element " + getElementName(webElement) +" not expected", text, webElement.getText());
        logger.info("Text in element " + getElementName(webElement) + " is expected");
    }
//    // method for select value in dropdown
//    protected void selectValueInDD(WebElement dropDownElement, String valueForSelect) {
//        try {
//            Select optionsFromDD = new Select(dropDownElement);
//            optionsFromDD.selectByValue(valueForSelect);
//            logger.info(valueForSelect + " value was selected in DropDown " + getElementName(dropDownElement));
//        } catch (Exception e) {
//            printErrorAndStopTest(e);
//        }
//    }

    // method for transforming string to UTF-8
    public static String stringTransformerInUT8(String name){
        byte[] utf8Bytes = name.getBytes(StandardCharsets.UTF_8);
        String utf8String = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String output = utf8String.replace(" ", "+");
        return output;
    }
    // method which extract number from attribute of element
    public String extractAttributeNumberFromElement(String locator, String attribute) {
        WebElement element = webDriver.findElement(By.xpath(locator));
        String atribut = element.getAttribute(attribute);
        String number = atribut.replaceAll("\\D+", ""); // Extract numeric part
        System.out.println("Extracted number: " + number);
        return number;
    }


//    ************************************************** private methods ********************************************
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
    protected boolean isElementVisible(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(getElementName(webElement) + "Element is displayed");
            } else {
                logger.info(getElementName(webElement) + "Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element  is not found");
            return false;
        }
    }
    protected boolean isElementVisible(String locator) {
        try {
            return isElementVisible(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            logger.info("Element is not found");
            return false;
        }
    }
}
