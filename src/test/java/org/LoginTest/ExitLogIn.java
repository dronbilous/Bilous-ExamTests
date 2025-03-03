package org.LoginTest;

import org.BaseTest.BaseTest;
import org.junit.Test;

import static org.testData.TestData.VALID_LOGIN;
import static org.testData.TestData.VALID_PASSWORD;

public class ExitLogIn extends BaseTest {
    @Test
    public void T0004_exitLogIn() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .enterTextIntoInputEmail(VALID_LOGIN)
                .enterTextIntoInputPassword(VALID_PASSWORD)
                .clickOnButtonSignIn()
                .checkIsRedirectOnHomePage()
                .checkIsIconLogInVisible();
        pageProvider.getHomePage()
                .clickOnDropDownMenu()
                .clickOnLogOutButton();
        pageProvider.getHomePage()
                .checkIsIconLogInNotVisible();
        pageProvider.getHomePage()
                .checkIsEnterButtonVisible();
    }
}
