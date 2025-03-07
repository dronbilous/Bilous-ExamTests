package org;

import org.BaseTest.BaseTest;
import org.junit.Test;

import static org.testData.TestData.*;

public class BooksOnHomePageTest extends BaseTest {

    @Test
    public void T0005_checkBooksOnHomePage() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnBookForNumber(NUMBER_BOOK_ON_HP)
                .compareTitle(testDataMap.get("Title"));
    }
}
