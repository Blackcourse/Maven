package Libra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_Android = "android";
    private static final String  Appium_URL= "http://0.0.0.0:4723/wd/hub";
    private static Platform instance;
    private Platform () {}

    public static Platform getInstance()
    {
        if (instance==null) {
            instance = new Platform();
        }
        return instance;
    }


    public AppiumDriver getDriver () throws Exception
    {
        URL URL = new URL (Appium_URL);
        if (this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapp());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapp());

        } else {
            throw new Exception("Cannot detect type of the Driver"+getPlatformVar());
        }
    }


    public boolean isAndroid ()
    {
        return isPlatform(PLATFORM_Android);
    }
    public boolean isIOS ()
    {
        return isPlatform(PLATFORM_IOS);
    }



    private DesiredCapabilities getAndroidDesiredCapp ()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\kgavr\\OneDrive\\Desktop\\Javaapp\\Javaapp\\apks\\org.wikipedia.apk");
        capabilities.setCapability("orientation", "PORTRAIT");
        return capabilities;
    }
    private DesiredCapabilities getIOSDesiredCapp ()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "Iphone SE");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("app", "C:\\Users\\kgavr\\OneDrive\\Desktop\\Javaapp\\Javaapp\\apks\\Wikipedia.app");

        return capabilities;
    }
    private boolean isPlatform (String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private String getPlatformVar () {
        return System.getenv("PLATFORM");
    }

}
