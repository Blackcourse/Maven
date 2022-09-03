package Libra.ui.IOS;

import Libra.ui.NavigationUI;
import io.appium.java_client.AppiumDriver;

public class IOSNavUi extends NavigationUI
{
    static  {
        MY_LIST_LINK = "id:Saved";
    }
    public IOSNavUi (AppiumDriver driver)
    {
        super(driver);
    }

}
