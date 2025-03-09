package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrentBookPage extends ParentPage {
    @FindBy(xpath = "//h1")
    private WebElement bookTitle;
    @FindBy(xpath = "//pjsdiv[@id='oframeplayer']")
    private WebElement player;

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

    public CurrentBookPage checkIsTitleEqualToExpected(String expectedTitle) {
        checkTextInElement(bookTitle, expectedTitle);
        return this;
    }

    public CurrentBookPage checkIsPlayerVisible() {
        checkIsElementVisible(player);
        return this;
    }
}
