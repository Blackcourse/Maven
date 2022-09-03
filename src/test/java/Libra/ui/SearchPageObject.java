package Libra.ui;

import io.appium.java_client.AppiumDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static  String
    SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
    /*Templates methods */
    private static String getResultSearchElement (String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*Templates methods */
    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }
    public void waitCancelButtonToAppear ()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);

    }
    public void clickCancelSearch ()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON,"Can't click on element",5);
    }

    public void typeSearchLine (String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT,search_line, "Cannot find and type into search input", 5);
    }
    public void waitForSearchResult (String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent (search_result_xpath, "Cannot find search result"+substring);
    }
    public void clickByArticleWithSubstring (String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick (search_result_xpath, "Cannot find and click search result"+substring,10);
    }
    public int getAmountOfFoundArticles ()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "cannt find anything",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }
    public void waitForEmptyResultsLabel ()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,"Ccannot find empty result element",15);


    }
    public void assertNoResult ()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"We supposed not find any results");
    }


}
