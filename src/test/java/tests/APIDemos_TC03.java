package tests;
//handling drag and drop
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class APIDemos_TC03 extends BaseCase {
	@Test
    public void handleElements3() throws MalformedURLException, InterruptedException {
        ExtentTest test = extent.createTest("Drag and Drop","Testing on different elements");
        test.log(Status.INFO, "Test execution started");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Click on "Views"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"))).click();

        // Click on "Drag and Drop"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"))).click();

        // Locate the source and destination elements
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/drag_dot_1")));
        WebElement dest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/drag_dot_2")));

        // Drag and drop using w3c
        //find center of source and target web element
	    Point sourceElementCenter = getCenter(source);
		Point targetElementCenter = getCenter(dest);
			
			//PointerInput class to create a sequence of actions 
			//that move the pointer to the center of the element, 
			//press down on the element, and then release the element.

			
		PointerInput finger1 = new PointerInput (PointerInput.Kind.TOUCH,"finger1");
			
			//Sequence object, which is a list of actions that will be performed on the device

		Sequence sequence = new Sequence (finger1, 1)
					
					//move finger to the starting position
					.addAction (finger1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
					
					
					//finger coming down to contact with screen
					.addAction (finger1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
					
					.addAction(new Pause(finger1, Duration.ofMillis(588)))
					
					//move finger to the end position
					.addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetElementCenter))
					
					//move the finger up
					.addAction (finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			//perform sequence of actions
			//driver.perform(Collections.singletonList(sequence));
		//
			driver.perform(Arrays.asList(sequence));
			Thread.sleep(2000);
			
			test.log(Status.PASS, "Test execution completed");
	
    }
private static Point getCenter(WebElement element)
{
	//get location of the element
	Point location = element.getLocation();
	
	//get dimension (height & width of the element)
	Dimension size = element.getSize();
	
	//center point
	Point center = new Point (location.x + size.width/2, location.y + size.height/2);
	
	return center;
	
}
}
