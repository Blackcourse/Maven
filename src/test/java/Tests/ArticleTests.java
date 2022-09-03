package Tests;

import Libra.CoreTestCase;
import Libra.ui.factory.ArticlePageObjectFactory;
import Libra.ui.factory.SearchPageObjectFactory;
import org.junit.Test;
import Libra.ui.ArticlePageObject;
import Libra.ui.SearchPageObject;

import static org.junit.Assert.assertEquals;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title=ArticlePageObject.getArticleTitle ();

        assertEquals(
                "We see unexp titile",
                "Java (programming language)",
                article_title
        );
    }
    @Test
    public void testSwipeArticle () {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject =ArticlePageObjectFactory.get(driver) ;
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeTofooter();
    }

}
