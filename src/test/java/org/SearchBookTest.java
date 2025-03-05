package org;

import org.BaseTest.BaseTest;
import org.junit.Test;

import static org.testData.TestData.TEST_BOOK;

public class SearchBookTest extends BaseTest {

    @Test
    public void T005_searchBookTest() {
        pageProvider.getHomePage().openHomePage();
        pageProvider.getHeaderSearchInputCategories()
                .inputTextInToInputSearch(TEST_BOOK)
                .clickOnButtonSearch()
                .checkIsRedirectOnSearchPage()
                .checkTitleOfSearchIsVisible(TEST_BOOK)
                .clickOnBookTitle(TEST_BOOK);



    }
}
