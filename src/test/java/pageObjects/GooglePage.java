package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class GooglePage {
    AndroidDriver driver;

    public GooglePage(AndroidDriver d){
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement searchBox;

    public void EnterData(String data){
        searchBox.sendKeys(data);
    }

    public void pressEnter(){
        searchBox.sendKeys(Keys.RETURN);
    }
    


}
