package Libra.ui;
import Libra.Platform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_BUTTON,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON;


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }

    public void swipeTofooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Can't swipe to footer",
                    40
            );
        } else {
            this.swipeUPTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }
    }


    public void addArticleToMyList (String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article",
                5
        );
        this.waitForElementAndClick(
               OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5

        );

        this.waitForElementAndClick(
             ADD_TO_MY_LIST_OVERLAY,
                "Cant click on Got it button",
                5
        );
        this.waitAndClear(
               MY_LIST_BUTTON,
                "Cannot find input to set name ",
                5

        );

        this.waitForElementAndSendKeys(
               MY_LIST_BUTTON,
                name_of_folder,
                "Cannot put text",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK",
                5

        );
    }
    public void addArticlesToMySave ()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "cannot click to add to my list button",5);
    }
    public void closeArticle (){
       this.waitForElementAndClick(
              CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X",
                5
        );
    }

}
