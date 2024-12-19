package tests;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class PhoneDialer_TC01 extends BaseCase{
    @Test
    public void callDialer() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Calling a number","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
        
        test.log(Status.INFO, "Dialing a number");
        
        driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
        driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
        driver.findElement(By.id("com.google.android.dialer:id/four")).click();
        driver.findElement(By.id("com.google.android.dialer:id/four")).click();
        driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
        driver.findElement(By.id("com.google.android.dialer:id/two")).click();
        driver.findElement(By.id("com.google.android.dialer:id/four")).click();
        driver.findElement(By.id("com.google.android.dialer:id/seven")).click();
        driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
        driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
        driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
       
        
        Thread.sleep(5000);    
        test.log(Status.PASS, "Test execution completed");
        
    }
}
