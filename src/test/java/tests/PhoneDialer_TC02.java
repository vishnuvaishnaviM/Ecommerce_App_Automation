package tests;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


//handling long press
public class PhoneDialer_TC02 extends BaseCase {
   
    @Test
    public void handleElements6() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Long press Button","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
        driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
        driver.findElement(By.id("com.google.android.dialer:id/four")).click();
        driver.findElement(By.id("com.google.android.dialer:id/four")).click();
        driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
        driver.findElement(By.id("com.google.android.dialer:id/two")).click();

        //back button
        WebElement backbtn = driver.findElement(By.id("com.google.android.dialer:id/deleteButton"));
        backbtn.click(); //deletes only one number

        System.out.println("deleted one number");
        test.log(Status.INFO, "Clicking on long press");
        longPress(backbtn);
        test.log(Status.PASS, "Test execution completed");
        
       
    }

    static void longPress(WebElement element){
        Point location = element.getLocation();
        PointerInput finger1 = new PointerInput (PointerInput.Kind.TOUCH,"finger1");
		Sequence sequence = new Sequence (finger1, 1);
        sequence.addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.getX(), location.getY()));
        sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), location.getX(),location.getY()));
        sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }
}
