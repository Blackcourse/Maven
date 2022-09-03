package Libra.ui.Android;

import Libra.ui.NavigationUI;
import io.appium.java_client.AppiumDriver;

public class AndroidNavUI extends NavigationUI {
    static {
        MY_LIST_LINK = "xpath://android.widget.FrameLayout [@content - desc = 'My list']";
    }
    public AndroidNavUI (AppiumDriver driver)
    {
        super(driver);
    }
}
