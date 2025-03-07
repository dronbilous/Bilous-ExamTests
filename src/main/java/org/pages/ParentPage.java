package org.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElement {

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected String baseUrl = "https://knigorai.com/";

    abstract protected String getRelativeUrl();

    protected void checkUrl() {
        Assert.assertEquals("URL is not expected", baseUrl + getRelativeUrl(), webDriver.getCurrentUrl());
    }
}
