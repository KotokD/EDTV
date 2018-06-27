package helpers;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public  class GestureHelper {
    public static void Scroll(AndroidDriver driver,String id) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"" + id + "\"));"));
    }
}
