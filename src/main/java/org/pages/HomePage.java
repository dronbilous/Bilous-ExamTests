package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testData.TestData;

import java.util.List;

public class HomePage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

//    ************************************************ find elements *********************************************
     @FindBy(xpath = "//a[@class='book-title']")
     private List<WebElement> bookTitlesOnHomePage;

//    ************************************************ Constructor ****************************************************
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
//    ***********************************************  Methods  *******************************************************
    @Override
    protected String getRelativeUrl() {return "";}

    public HomePage checkIsRedirectOnHomePage() {
        checkUrl();
        return this;
    }
    public HomePage openHomePage() {
        webDriver.get(baseUrl);
        logger.info("Home Page was opened with url " + baseUrl);
        return this;
    }
    public CurrentBookPage clickOnBookForNumber(int number) {
        receiveBookTitle(number);
        clickOnElement(bookTitlesOnHomePage.get(number));
        return new CurrentBookPage(webDriver);
    }
    public void receiveBookTitle(int number) {
        String bookTitle = bookTitlesOnHomePage.get(number).getAttribute("title");
        String selectedBookTitle = bookTitle.replace("Слушать аудиокнигу", "").trim();
        TestData.testDataMap.put("Title", selectedBookTitle);
    }





}
