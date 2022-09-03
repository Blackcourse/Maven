package Libra.ui.IOS;

import Libra.ui.ArticlePageObject;
import io.appium.java_client.AppiumDriver;

public class IOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
                FOOTER_ELEMENT = "id:View article in browser";
                OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
                OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
                CLOSE_ARTICLE_BUTTON = "xpath//android.widget.ImageButton[@content-desc='Navigate up']";
    }
    public IOSArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }



}
