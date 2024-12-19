package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Ecommerce_TC01 extends BaseCase {
    @Test
    public void testValidLogin() {
        ExtentTest test = extent.createTest("Test login - valid", "Test login functionality with valid data");

        try {
            test.log(Status.INFO, "Enter name");
            driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("vishnu");
            //to hide keyboard
            driver.hideKeyboard();
            test.log(Status.INFO, "Click on dropdown to select a country");
            driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click(); // Use a more robust locator

            test.log(Status.INFO, "Scroll to view and select 'India'");
            String elementToScroll = "Antarctica";
            WebElement scroll = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" + 
                ".scrollIntoView(new UiSelector().text(\"" + elementToScroll + "\"))"
            ));
            scroll.click();

            test.log(Status.INFO, "Select radio button to choose Female");
            driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

            test.log(Status.INFO, "Click on 'Let's Shop' button");
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

            test.log(Status.INFO, "Verify login success");
            Thread.sleep(4000);
            String login = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
            Assert.assertEquals(login, "Products", "Login validation failed");

            test.log(Status.PASS, "Test case passed");

        } catch (Exception e) {
            test.log(Status.FAIL, "Test case failed due to: " + e.getMessage());
            Assert.fail("Test case failed: " + e.getMessage());
        }
    }


    @Test
    public void testInvalidLogin() throws InterruptedException {
        ExtentTest test = extent.createTest("Test login- invalid", "Test login functionality with invalid data");


            test.log(Status.INFO, "Click on dropdown to select a country");
            driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click(); // Use a more robust locator

            test.log(Status.INFO, "Scroll to view and select 'Antarctica'");
            String elementToScroll = "Antarctica";
            WebElement scroll = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" + 
                ".scrollIntoView(new UiSelector().text(\"" + elementToScroll + "\"))"
            ));
            scroll.click();

            test.log(Status.INFO, "Select radio button to choose Female");
            driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

            test.log(Status.INFO, "Click on 'Let's Shop' button");
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

            test.log(Status.INFO, "Verify failed login message");
            Thread.sleep(4000);
            try{
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Toast\")")));
            String feedback = toast.getText();
            System.out.println("Toast Message: " + feedback);

            }catch(Exception e){
                System.out.println("Failed to locate Toast message: " + e.getMessage());
            }

            test.log(Status.FAIL, "Test case failed due to: ");
        
    }
}