package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrentBookPage extends ParentPage{
    @FindBy(xpath = "//h1")
    private WebElement bookTitle;

    public CurrentBookPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public CurrentBookPage checkIsElementVisible() {
        checkIsElementVisible(bookTitle);
        return this;
    }
    public CurrentBookPage compareTitle(String expectedTitle) {
        String actualTitle = bookTitle.getText();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Titles are equal");
        } else {
            System.out.println("Titles are not equal");
        }
        return this;
    }





}
