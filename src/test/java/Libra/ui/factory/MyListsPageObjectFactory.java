package Libra.ui.factory;

import Libra.Platform;
import Libra.ui.Android.AndroidMyListsPageObject;
import Libra.ui.IOS.IOSMyListsPageObject;
import Libra.ui.MyListPageObject;
import io.appium.java_client.AppiumDriver;

public class MyListsPageObjectFactory {
    public static MyListPageObject get (AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else {
            return new IOSMyListsPageObject(driver);
        }
    }

}
