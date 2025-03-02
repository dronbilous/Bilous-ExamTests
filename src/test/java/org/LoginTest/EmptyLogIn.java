package org.LoginTest;

import org.BaseTest.BaseTest;
import org.junit.Test;

public class EmptyLogIn extends BaseTest {
    @Test
    public void T0002_emptyLogIn() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .clickOnButtonSignIn();
        pageProvider.getLoginPage()
                .checkIsWarningMessageEmailVisible()
                .checkIsWarningMessagePasswordVisible();
    }
}
