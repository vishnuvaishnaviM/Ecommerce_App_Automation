package tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.appium.java_client.android.AndroidDriver;

public class BaseCase extends ExtentReport {
    protected static AndroidDriver driver;

    @Parameters({"platformName", "deviceName", "automationName", "appPackage", "appActivity", "appType", "browserName", "chromedriverPath"})
    @BeforeMethod
    public void setCapabilities(
        String platformName, 
        String deviceName,
        String automationName,
        @Optional("") String appPackage,
        @Optional("") String appActivity,
        @Optional("") String appType,
        @Optional("") String browserName,
        @Optional("") String chromedriverPath
    ) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("PLATFORM_NAME", platformName);
        capabilities.setCapability("DEVICE_NAME", deviceName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("chromedriverAutodownload", true);

        if ("native".equalsIgnoreCase(appType)) {
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            
            
        } else if ("web".equalsIgnoreCase(appType)) {
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("chromedriverExecutable", chromedriverPath);
        }

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        Thread.sleep(5000);
        System.out.println("App is launched successfully!");

        
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver session ended.");
        }
        
    }
}
