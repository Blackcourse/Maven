package Tests;

import Libra.CoreTestCase;
import Libra.Platform;
import Libra.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome ()
    {
        if (Platform.getInstance().isAndroid()) {
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);
        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOnEditPreffer();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutData();
        WelcomePage.clickGetStartedButton();

    }





}
