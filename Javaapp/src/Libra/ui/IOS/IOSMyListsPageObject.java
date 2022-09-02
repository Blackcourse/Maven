package Libra.ui.IOS;

import Libra.ui.MyListPageObject;
import io.appium.java_client.AppiumDriver;

public class IOSMyListsPageObject extends MyListPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIEElementTypeLink [contains(@name = '{TITLE}')]";
    }

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}

