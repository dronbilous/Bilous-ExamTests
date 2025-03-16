package org.LoginTest;

import org.BaseTest.BaseTest;
import org.junit.Test;

import static org.testData.TestData.INVALID_PASSWORD;
import static org.testData.TestData.VALID_LOGIN;

public class InvalidLogin extends BaseTest {
    @Test
    public void T0002_invalidLogin() {
        pageProvider.getHomePage()
                .openHomePage();
        pageProvider.getHeaderSearchInputCategories().clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .enterTextIntoInputEmail(VALID_LOGIN)
                .enterTextIntoInputPassword(INVALID_PASSWORD)
                .clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsWarningMessageInputVisible();
        pageProvider.getHeaderSearchInputCategories().checkIsIconLogInNotVisible();
    }
    @Test
    public void T0003_emptyLogIn() {
        pageProvider.getHomePage()
                .openHomePage();
        pageProvider.getHeaderSearchInputCategories().clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .clickOnButtonSignIn();
        pageProvider.getLoginPage()
                .checkIsWarningMessageEmailVisible()
                .checkIsWarningMessagePasswordVisible();
    }

}