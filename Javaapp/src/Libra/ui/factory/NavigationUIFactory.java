package Libra.ui.factory;

import Libra.Platform;
import Libra.ui.Android.AndroidNavUI;
import Libra.ui.IOS.IOSNavUi;
import Libra.ui.NavigationUI;
import io.appium.java_client.AppiumDriver;

public class NavigationUIFactory {
    public static NavigationUI get (AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavUI(driver);
        }else {
            return new IOSNavUi(driver);
        }
    }
}
