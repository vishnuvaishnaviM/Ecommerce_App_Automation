package tests;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

//validate mobile gestures working for links and navigate to webView
public class Ecommerce_TC04 extends BaseCase{
    @Test 
    public void validateGestures() throws InterruptedException{
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
        
    //mobile gesture - tap on the checkbox to accept terms and conditions
    tap(driver, driver.findElement(By.className("android.widget.CheckBox")));

     
    //mobile gesture - long press on the terms and conditions page to check if it displays popup 
    longPress(driver, driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']")));
    driver.findElement(By.id("android:id/button1")).click();

    test.log(Status.INFO, "Entering web view");
    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    Thread.sleep(3000);

    Set<String> contextNames = driver.getContextHandles();
    for (String contextName : contextNames) {
        System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
    }
    driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

    driver.findElement(By.name("q")).sendKeys("APPIUM automation");
    Thread.sleep(2000);

    driver.context("NATIVE_APP");



    }

    private void tap (AndroidDriver driver, WebElement element) {
         Point location = element.getLocation();
         Dimension size = element.getSize();
         Point centerOfElement = getCenterOfElement(location, size);
         PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
         Sequence sequence = new Sequence(finger1, 1)
                 .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                 .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                 .addAction(new Pause(finger1, Duration.ofMillis(200)))
                 .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
         driver.perform(Collections.singletonList(sequence));
}
    
    private Point getCenterOfElement(Point location, Dimension size)
    {
    return new Point(location.getX() + size.getWidth()/2,
            location.getY()+ size.getHeight()/2);
    }

    //longpress
    private void longPress (AndroidDriver driver, WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCenterOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//waiting for 2 seconds for longPress on the Element
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
       
        driver.perform(Collections.singletonList(sequence));
}    
    
}
