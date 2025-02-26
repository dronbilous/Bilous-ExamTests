package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

}
