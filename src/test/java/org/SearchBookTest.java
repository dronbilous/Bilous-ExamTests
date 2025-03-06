package org;

import org.BaseTest.BaseTest;
import org.junit.Test;

import static org.testData.TestData.TEST_BOOK;

public class SearchBookTest extends BaseTest {

    @Test
    public void T004_searchBookForTitle() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getHeaderSearchInputCategories()
                .inputTextInToInputSearch(TEST_BOOK)
                .clickOnButtonSearch()
                .checkIsRedirectOnSearchPage()
                .checkTitleOfSearchIsVisible(TEST_BOOK);
        pageProvider.getSearchPage()
                .clickOnBookTitle(TEST_BOOK)
                .checkIsElementVisible()
                .compareTitle(TEST_BOOK);
    }
}
