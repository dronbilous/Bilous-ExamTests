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
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//strong[text()='Поле e-mail обязательно для заполнения.']")
    private WebElement warningMessageEmail;
    @FindBy(xpath = "//strong[text()='Поле Пароль обязательно для заполнения.']")
    private WebElement warningMessagePassword;
    @FindBy(xpath = "//strong")
    private WebElement warningInputMessage;

//    ************************************************ Constructor ****************************************************
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
//    *****************************************************************************************************************

//    ***********************************************  Methods  *******************************************************
    @Override
    protected String getRelativeUrl() {return "login";}

    public LoginPage checkIsRedirectOnLoginPage() {
        checkUrl();
        return this;
    }
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
    public LoginPage checkIsWarningMessageEmailVisible() {
        checkTextInElement(warningMessageEmail, "Поле e-mail обязательно для заполнения.");
        return this;
    }
    public LoginPage checkIsWarningMessagePasswordVisible() {
        checkTextInElement(warningMessagePassword, "Поле Пароль обязательно для заполнения.");
        return this;
    }
    public LoginPage checkIsWarningMessageInputVisible() {
        checkIsElementVisible(warningInputMessage);
        checkTextInElement(warningInputMessage, "Неверные данные для входа.");
        return this;
    }

}
