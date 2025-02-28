package org.LoginTest;

import org.BaseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void T0001_ValidLogin() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnEnterButton()
                .checkIsRedirectOnLoginPage()
                .enterTextIntoInputEmail("scatterqa@gmail.com")
                .enterTextIntoInputPassword("white2233")
                .clickOnButtonSignIn()
                .checkIsRedirectOnHomePage();



    }
}
