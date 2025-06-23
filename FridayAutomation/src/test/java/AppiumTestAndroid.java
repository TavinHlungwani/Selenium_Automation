import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestAndroid {
    public static void main(String[] args) throws MalformedURLException {

        // Set the desired capabilities for the Android device
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy A12");
        capabilities.setCapability("app", "androidApp/build.apk");

        // Create a new instance of the Appium driver
        AppiumDriver<MobileElement> appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);
        // Perform your test actions
        // ...
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Quit the driver
        appiumDriver.quit();
    }
}
