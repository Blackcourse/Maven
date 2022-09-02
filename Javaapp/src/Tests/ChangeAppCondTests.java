package Tests;

import Libra.CoreTestCase;
import Libra.ui.ArticlePageObject;
import Libra.ui.SearchPageObject;
import Libra.ui.factory.ArticlePageObjectFactory;
import Libra.ui.factory.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppCondTests extends CoreTestCase {
    @Test
    public void testChangeScreenOrientation() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been changed after rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been changed after rotation",
                title_before_rotation,
                title_after_second_rotation
        );

    }

    public void testCheckSearchArticleBackground () {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }




}
