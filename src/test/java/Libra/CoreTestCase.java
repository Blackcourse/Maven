package Libra;
import Libra.ui.WelcomePageObject;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;


public class CoreTestCase extends TestCase {

    public AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver=Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageIos();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
    protected void rotateScreenPortrait ()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape ()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    protected void backgroundApp (int sec)
    {
        driver.runAppInBackground(Duration.ofDays(2));
    }

    private void skipWelcomePageIos ()
    {
        if (Platform.getInstance().isIOS()){
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip ();
        }
    }



    }



