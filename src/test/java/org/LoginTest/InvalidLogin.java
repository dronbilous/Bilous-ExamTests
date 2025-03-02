package org.LoginTest;

import org.BaseTest.BaseTest;
import org.junit.Test;

public class InvalidLogin extends BaseTest {
    @Test
    public void T0003_invalidLogin() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .enterTextIntoInputEmail("scatterqa@gmail.com")
                .enterTextIntoInputPassword("123")
                .clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsWarningMessageInputVisible();
        pageProvider.getHomePage()
                .checkIsIconLogInNotVisible();
    }
}
