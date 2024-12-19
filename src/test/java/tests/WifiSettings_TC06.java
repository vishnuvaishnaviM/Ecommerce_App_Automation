package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WifiSettings_TC06 extends BaseCase{
    @Test
    public void modifyWifiSettings() throws InterruptedException{
        ExtentTest test = extent.createTest("Modifying Wifi settings","Edit wifi settings");
        test.log(Status.INFO, "Test Execution started");
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
        test.log(Status.INFO, "clicked on preferences");
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        test.log(Status.INFO, "Clicked on preferences dependencies");
        driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
        test.log(Status.INFO, "Enabled Wifi");
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
        test.log(Status.INFO, "Clicked on wifi settings");
        driver.findElement(By.className("android.widget.EditText")).sendKeys("settings");
        test.log(Status.INFO, "entered wifi settings in the popup");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();
        test.log(Status.INFO, "Clicked on ok in the popup");
        Thread.sleep(5000);
        test.log(Status.PASS, "Test execution completed");
    }
    
}
