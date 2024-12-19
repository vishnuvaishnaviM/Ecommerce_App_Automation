package tests;
//scroll in the web pages
import java.net.MalformedURLException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.GooglePage;

//handling scrolling mobile web page, switches
public class Chrome_TC01 extends BaseCase{
    @Test
    public void handleElements2() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Scrolling and switches","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        //click on views
         driver.get("https://www.google.com/");
        test.log(Status.INFO, "Navigated to Google homepage");

        GooglePage gp = new GooglePage(driver);
        gp.EnterData("Appium automation testing");
        gp.pressEnter();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        test.log(Status.PASS, "Test execution completed");

        Thread.sleep(5000);
    }
    
}
