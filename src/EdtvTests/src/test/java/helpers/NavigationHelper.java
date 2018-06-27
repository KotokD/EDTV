package helpers;

import io.appium.java_client.android.AndroidDriver;

public class NavigationHelper {
    private void navigateToSettings(AndroidDriver driver) {
        driver.findElementByClassName("android.widget.ImageButton").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Settings\")").click();
    }
}
