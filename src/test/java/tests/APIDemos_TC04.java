package tests;
//handling drop down
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class APIDemos_TC04 extends BaseCase {
    @Test
    public void handleElements4() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("DropDown","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        //click on views
        driver.findElements(By.id("android:id/text1")).get(10).click();
        //click on controls
        driver.findElements(By.id("android:id/text1")).get(4).click();
        //click on light theme
        driver.findElements(By.id("android:id/text1")).get(0).click();
        
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Saturn\"]")).click();
        Thread.sleep(3000);
        test.log(Status.INFO, "Test execution completed");
    }
    
}
