package helpers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class AuthHelper {
    private static void SignUpStep1(AndroidDriver driver, String email, String password) {
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sign Up\")").click();
        driver.findElementById(ResourceId.signUpEmailField).sendKeys(email);
        driver.hideKeyboard();
        driver.findElementById(ResourceId.signUpPasswordField).sendKeys(password);
        driver.hideKeyboard();
        driver.findElementById(ResourceId.signUpButton).click();
        driver.findElementById(ResourceId.firstNameField).sendKeys("Name");
        driver.findElementById(ResourceId.lastNameField).sendKeys("LastName");
        driver.findElementById(ResourceId.phoneField).sendKeys("1234567");
        driver.hideKeyboard();
        driver.findElementById(ResourceId.zipCodeField).sendKeys("12345");
        GestureHelper.Scroll(driver, ResourceId.finishRegistrationButton);
        driver.findElementById(ResourceId.schoolDropDown).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.edtv:id/tvName\").index(0)").click();
        driver.findElementById(ResourceId.roleDropDown).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.edtv:id/tvName\").index(0)").click();
        driver.findElementById(ResourceId.finishRegistrationButton).click();
        driver.findElementById(ResourceId.dialogOkButton).click();
    }

    public static void SignUpEditProfile(AndroidDriver driver, String email, String password) {
        SignUpStep1(driver, email, password);
        driver.findElementById("com.edtv:id/tvDatePicker").click();
        driver.findElementById("android:id/prev").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"1\")").click();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.edtv:id/etAbout").sendKeys("Hello");
        driver.hideKeyboard();
        GestureHelper.Scroll(driver, "com.edtv:id/bRegister");
        driver.findElementById("com.edtv:id/bRegister").click();
    }
    public static void SignUpSkipEditProfile(AndroidDriver driver, String email, String password) {
        SignUpStep1(driver, email, password);
        driver.findElementById("com.edtv:id/bSkip").click();
    }

   public static void SignIn(AndroidDriver driver, String email, String password) throws MalformedURLException {
        driver.findElementById("com.edtv:id/etLoginEmail").sendKeys(email);
        driver.hideKeyboard();
        driver.findElementById("com.edtv:id/etLoginPassword").sendKeys(password);
        driver.hideKeyboard();
        driver.findElementById("com.edtv:id/btLogIn").click();
        WebElement edtvTitle = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"EDTV\")");
        boolean isDisplayed = edtvTitle.isDisplayed();
    }
}
