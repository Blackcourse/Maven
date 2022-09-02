package Tests;

import Libra.CoreTestCase;
import Libra.ui.SearchPageObject;
import Libra.ui.factory.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch () {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
    @Test
    public void testCancelSearch ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();

    }


    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject =SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        int amount_of_search_results=SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found few results",
                amount_of_search_results >0
        );
    }

    @Test
    public void testofEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        String search_line = "zxcv43534bbn";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertNoResult();

    }
}
