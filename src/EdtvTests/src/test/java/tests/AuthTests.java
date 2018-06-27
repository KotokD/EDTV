package tests;

import helpers.AuthHelper;
import helpers.ResourceId;
import helpers.TestСonstants;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class AuthTests extends BaseTest {


    @Test
    public void SignUpEditProfile() {
        AuthHelper.SignUpEditProfile(driver, TestСonstants.genarateUniqueEmail(), TestСonstants.passwordForRegistration);
        WebElement VerifyB = driver.findElementById("com.edtv:id/bVerify");
        boolean isDisplayed = VerifyB.isDisplayed();
    }

    @Test
    public void SignUpSkipEditProfile() {
        AuthHelper.SignUpSkipEditProfile(driver, TestСonstants.genarateUniqueEmail(), TestСonstants.passwordForRegistration);
        WebElement VerifyB = driver.findElementById("com.edtv:id/bVerify");
        boolean isDisplayed = VerifyB.isDisplayed();
    }

    @Test
    public void EditProfile() throws MalformedURLException {
        AuthHelper.SignIn(driver, TestСonstants.emailForLogin, TestСonstants.passwordForLogin);
        driver.findElementByClassName("android.widget.ImageButton").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Settings\")").click();
        driver.findElementById(ResourceId.editProfile).click();
        String firstName = TestСonstants.generateRandomString(10);
        String lastName = TestСonstants.generateRandomString(10);
        driver.findElementById(ResourceId.firstNameField).clear();
        driver.findElementById(ResourceId.firstNameField).sendKeys(firstName);
        driver.hideKeyboard();
        driver.findElementById(ResourceId.lastNameField).clear();
        driver.findElementById(ResourceId.lastNameField).sendKeys(lastName);
        driver.hideKeyboard();
        driver.findElementById(ResourceId.saveButton).click();
        driver.resetApp();
        AuthHelper.SignIn(driver, TestСonstants.emailForLogin, TestСonstants.passwordForLogin);
        String valueOfFirstName = driver.findElementById(ResourceId.firstNameField).getText();
        assertEquals(firstName, valueOfFirstName);
        String valueOfLastName = driver.findElementById(ResourceId.lastNameField).getText();
        assertEquals(lastName, valueOfLastName);
    }


}