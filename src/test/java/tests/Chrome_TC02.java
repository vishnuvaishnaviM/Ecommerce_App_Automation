package tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pageObjects.GooglePage;

public class Chrome_TC02 extends BaseCase {

    @Test
    public void search() throws InterruptedException {
        ExtentTest test = extent.createTest("test chrome","Testing on chrome web on mobile");
        test.log(Status.INFO, "Test execution started");

        driver.get("https://www.google.com/");
        test.log(Status.INFO, "Navigated to Google homepage");

        GooglePage gp = new GooglePage(driver);
        gp.EnterData("Appium automation testing");
        gp.pressEnter();

        test.log(Status.PASS, "Search query executed successfully:");
        Thread.sleep(5000);
    }
}
