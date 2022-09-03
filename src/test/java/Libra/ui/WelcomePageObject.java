package Libra.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {
    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK = "id:Learn more about data collector",
    NEXT_LINK = "id:Next",
    GET_STARTED_BUTTON = "id:Get started",
    SKIP = "id:Skip";
    public WelcomePageObject (AppiumDriver driver)
    {
        super(driver);
    }

    public void  waitForLearnMoreLink ()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,"Can't find learn more about Wikipedia",10);
    }
    public void  waitForNewWayToExploreText ()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,"Can't find learn more about Wikipedia",10);
    }
    public void  waitForAddOnEditPreffer ()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK,"Can't find learn more about Wikipedia",10);
    }
    public void  waitForLearnMoreAboutData ()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,"Can't find add to collected",10);
    }

    public void  clickNextButton ()
    {
        this.waitForElementAndClick(NEXT_LINK,"Can't find and click Next link",10);
    }
    public void  clickGetStartedButton ()
    {
        this.waitForElementPresent(GET_STARTED_BUTTON,"Can't find and click Get started",10);
    }

public void clickSkip ()
{
    this.waitForElementAndClick(SKIP, "Cannot find skip button",10);
}

}
