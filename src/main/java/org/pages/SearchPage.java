package org.pages;

import org.openqa.selenium.WebDriver;
import org.testData.TestData;

import static org.testData.TestData.TEST_BOOK;

public class SearchPage extends ParentPage{
    public String locatorForBookTitle = "//a[contains(text(),'%s')]";

    static String bookForSearch = TEST_BOOK;
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return makeURL();
    }
    public SearchPage checkIsRedirectOnSearchPage() {
        checkUrl();
        return this;
    }
    public SearchPage checkTitleOfSearchIsVisible(String text) {
        checkIsElementVisible(String.format(locatorForBookTitle, text));
        return this;
    }
    public CurrentBookPage clickOnBookTitle(String text) {
        clickOnElement(String.format(locatorForBookTitle, text));
        return new CurrentBookPage(webDriver);
    }

    private static String makeURL() {
        String paramURL = stringTransformerInUT8(bookForSearch);
        String url = "?q=" + paramURL;
        return url;
    }
}
