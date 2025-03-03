package org.LoginTest;

import org.BaseTest.BaseTest;
import org.junit.Test;

public class ExitLogIn extends BaseTest {
    @Test
    public void T0004_exitLogIn() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .enterTextIntoInputEmail("scatterqa@gmail.com")
                .enterTextIntoInputPassword("white2233")
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
