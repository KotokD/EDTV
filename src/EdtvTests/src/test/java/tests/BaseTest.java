package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "4c6a4d2c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", Paths.get("edtv-android.apk").toAbsolutePath().normalize().toString());//"D:\\Work\\EDTV-testandroid\\edtv-android.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
