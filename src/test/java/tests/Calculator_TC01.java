package tests;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Calculator_TC01 extends BaseCase{
    @Test
    public void testCalculator() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Testing calculator app","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        driver.findElement(By.id("com.asus.calculator:id/digit8")).click();
        driver.findElement(By.id("com.asus.calculator:id/plus")).click();
        driver.findElement(By.id("com.asus.calculator:id/digit2")).click();
        driver.findElement(By.id("com.asus.calculator:id/equal")).click();
        String res = driver.findElement(By.id("com.asus.calculator:id/resultEditTextID")).getText();
        if(res.equals("10")){
            System.out.println("test case passed");
        }
        test.log(Status.PASS, "Test execution completed");

    }
}
