package org.pages;

import org.openqa.selenium.WebDriver;

public class CurrentBookPage extends ParentPage{

    public CurrentBookPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "";
    }

    public CurrentBookPage checkIsRedirectOnSearchedBook() {
        checkUrl();
        return this;
    }



}
