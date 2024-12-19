package tests;
//handling scroll or swipe
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class APIDemos_TC05 extends BaseCase{
	@Test
    public void handleElements5() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Scroll or swipe","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
		//click on views
        driver.findElements(By.id("android:id/text1")).get(10).click();
        //Get Screen size
		Dimension size = driver.manage().window().getSize();
		test.log(Status.INFO, "Testing scroll functionality");
		//find the position where you need to touch
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		
		//position till you want to move your finger to swipe
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);
		
		//PointerInput class to create a sequence of actions 
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		
		//Sequence object, which is a list of actions that will be performed on the device
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

		//perform the Sequence of action
		driver.perform(Collections.singletonList(sequence));
		
		Thread.sleep(2000);
		test.log(Status.PASS, "Test execution completed");
	     
    }
    
}
