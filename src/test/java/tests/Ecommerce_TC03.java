package tests;
//validate the total cost at the checkout is sum of the cost of the added items
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Ecommerce_TC03 extends BaseCase{
    @Test
    public void validateCost() throws InterruptedException{
        ExtentTest test = extent.createTest("Test login - valid", "Test login functionality with valid data");
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
        //selecting first two items to the cart
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //since after selecting first item, ADD to CART text will be modified and there will be only one item in the page that is visible with text - ADD TO CART
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
         //click on checkout button
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);
        test.log(Status.INFO, "validating total cost of the added items in the cart");
        Double totalvalue = 0.0;
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        for(int i=0;i<count;i++){
            String amt = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            Double amtValue = getAmount(amt);
            test.log(Status.INFO,"Cost of item number "+ i + " equals " + amtValue);
            totalvalue+=amtValue;
        }
        String acttotal = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double actValue = getAmount(acttotal);
        Assert.assertEquals(totalvalue, actValue);
        test.log(Status.PASS, "Test case passed to validate total cost");
        
    }

    public static double getAmount(String amount){
        amount=amount.substring(1);
        Double amtvalue = Double.parseDouble(amount);
        return amtvalue;
    }
}
