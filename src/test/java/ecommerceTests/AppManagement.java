package ecommerceTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AppManagement {
    public static void main(String[] args) throws MalformedURLException {
        // Set desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "asus ASUS_X01AD");
        capabilities.setCapability("automationName", "UiAutomator2");

        // Initialize Appium driver
        URL serverURL = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(serverURL, capabilities);

        // App details
        String packageName = "io.appium.android.apis";
        String appPath = "C:/semester3/project/Appium/src/ApiDemos-debug.apk";
        File app = new File(appPath);

        try {
            // Check if the app is already installed
            if (!driver.isAppInstalled(packageName)) {
                // Install the app if not already installed
                driver.installApp(app.getAbsolutePath());
                System.out.println("App installed successfully.");
                // Activate the app
                driver.activateApp(packageName);
                Thread.sleep(5000);
                //terminate the app
                driver.terminateApp(packageName);
            } else {
                System.out.println("App is already installed.");
                // remove the app
                driver.removeApp(packageName);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}
