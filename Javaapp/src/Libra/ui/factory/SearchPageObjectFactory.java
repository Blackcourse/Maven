package Libra.ui.factory;

import Libra.Platform;
import Libra.ui.Android.AndroidSearchPageObject;
import Libra.ui.IOS.IOSSearchPageObject;
import Libra.ui.SearchPageObject;
import io.appium.java_client.AppiumDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(driver);
        } else {
            return new IOSSearchPageObject(driver);

        }
    }
}
