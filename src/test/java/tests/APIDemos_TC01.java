package tests;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//handling textbox, checkbox, radio buttons
public class APIDemos_TC01 extends BaseCase {
    @Test
    public void handleElements1() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Handling textbox, checkbox, radiobutton","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        driver.findElements(By.id("android:id/text1")).get(10).click();
        //click on controls
        driver.findElements(By.id("android:id/text1")).get(4).click();
        //click on light theme
        driver.findElements(By.id("android:id/text1")).get(0).click();
        //enter text in the textbox
        test.log(Status.INFO, "Testing on textbox");
        driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("enter text in the textbox");
        //click on the checkboxes
        test.log(Status.INFO, "Testing on checkbox");
        driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
        driver.findElement(By.id("io.appium.android.apis:id/check2")).click();
        //click on radio button
        test.log(Status.INFO, "Testing on radio button");
        driver.findElement(By.id("io.appium.android.apis:id/radio1")).click();
        test.log(Status.PASS, "Test execution completed");
        
    }
    
}
