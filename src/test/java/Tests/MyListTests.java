package Tests;

import Libra.CoreTestCase;
import Libra.Platform;
import Libra.ui.ArticlePageObject;
import Libra.ui.MyListPageObject;
import Libra.ui.NavigationUI;
import Libra.ui.SearchPageObject;
import Libra.ui.factory.ArticlePageObjectFactory;
import Libra.ui.factory.MyListsPageObjectFactory;
import Libra.ui.factory.NavigationUIFactory;
import Libra.ui.factory.SearchPageObjectFactory;
import org.junit.Test;

public class MyListTests extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testFirstToMylist() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get (driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }else {
           ArticlePageObject.addArticlesToMySave();
        }
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyList();

        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        }
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
    }



}
