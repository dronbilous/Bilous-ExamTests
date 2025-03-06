package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

//    ************************************************ find elements *********************************************



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





}
