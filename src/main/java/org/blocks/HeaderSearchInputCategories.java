package org.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pages.CommonActionsWithElement;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.SearchPage;

public class HeaderSearchInputCategories extends CommonActionsWithElement {
// ****************************************** Locators/ WebElements *************************************************
    @FindBy(xpath = "//a[@href='https://knigorai.com/login']")
    private WebElement enterButton;
    @FindBy(xpath = "//img[@class='profile-image']")
    private WebElement iconLogIn;
    @FindBy(xpath = "//input")
    private WebElement inputSearch;
    @FindBy(xpath = "//button")
    private WebElement buttonSearch;
    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    private WebElement dropDownMenu;
    @FindBy(xpath = "//a[@href='https://knigorai.com/logout']")
    private WebElement logOutButton;

    public HeaderSearchInputCategories(WebDriver webDriver) {super(webDriver);}

    public LoginPage clickOnEnterButton() {
        clickOnElement(enterButton);
        return new LoginPage(webDriver);
    }
    public void checkIsIconLogInVisible() {
        checkIsElementVisible(iconLogIn);
    }
    public void checkIsIconLogInNotVisible() {
        checkIsElementNotVisible(iconLogIn);
    }
    public void checkIsEnterButtonVisible() {
        checkIsElementVisible(enterButton);
    }
    public HeaderSearchInputCategories clickOnDropDownMenu() {
        clickOnElement(dropDownMenu);
        return this;
    }
    public void clickOnLogOutButton() {
        clickOnElement(logOutButton);
    }
    public SearchPage clickOnButtonSearch() {
        clickOnElement(buttonSearch);
        return new SearchPage(webDriver);
    }
    public HeaderSearchInputCategories inputTextInToInputSearch(String text) {
        clearAndEnterTextIntoElement(inputSearch, text);
        return this;
    }


}
