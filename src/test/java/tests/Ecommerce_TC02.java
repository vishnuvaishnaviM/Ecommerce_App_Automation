package tests;
//shop for specific item and add to the cart - and validate if the added item is listed in the cart
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Ecommerce_TC02 extends BaseCase{
    @Test 
    public void selectProduct() throws InterruptedException{
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

        test.log(Status.PASS, "Test case passed");
        
        
     driver.findElement(AppiumBy.androidUIAutomator(
    "new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
    ".scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"
        ));
        
    //to click on add to cart
    int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
    for(int i=0;i<count;i++){
        String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        System.out.println(text);
        if(text.equals("Jordan 6 Rings")){
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            break;
        }
    }
 
    //click on checkout button
    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    test.log(Status.INFO, "validating the added item in the cart");
    String itemname = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
    if(itemname.equals("Jordan 6 Rings")){
        test.log(Status.PASS, "Test validation passed");
    }else{
        test.log(Status.FAIL, "Test validation failed");
    }
    }
    
}
