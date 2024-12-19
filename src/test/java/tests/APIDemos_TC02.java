package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;
//handling scrolling mobile web page, switches
public class APIDemos_TC02 extends BaseCase{
    @Test
    public void handleElements2() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Scrolling and switches","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        //click on views
        driver.findElements(By.id("android:id/text1")).get(10).click();
        test.log(Status.INFO, "Testing on scrolling functionality");
        //scrolling the web page
        String elementToScroll = "Switches";
        WebElement scroll = driver.findElement(AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" + 
                             ".scrollIntoView(new UiSelector().text(\"" + elementToScroll + "\"))"
                            ));
        scroll.click();
        test.log(Status.INFO, "Testing on switches functionality");
        //handling switches
        WebElement monitorSwitch = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));

        if(monitorSwitch.isSelected()){
            System.out.println("switch is already turned on");
        }else{
            monitorSwitch.click();
            System.out.println("switch is turned on now");
        }
        test.log(Status.PASS, "Test execution completed");

        
    }
    
}
