package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    private Logger logger = Logger.getLogger(getClass());

//    ************************************************ find elements *********************************************
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id=\'password\']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSignIn;

//    ************************************************ Constructor ****************************************************
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
//    *****************************************************************************************************************

    public LoginPage enterTextIntoInputEmail(String email) {
        clearAndEnterTextIntoElement(inputEmail, email);
        return this;
    }
    public LoginPage enterTextIntoInputPassword(String password) {
        clearAndEnterTextIntoElement(inputPassword, password);
        return this;
    }
    public HomePage clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
        return new HomePage(webDriver);
    }

}
