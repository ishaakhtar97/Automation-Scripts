package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
	
	 WebDriver driver;
	    WebDriverWait wait;

	    // Example locator for your app's home page after successful login
	    private By yesButton = By.id("idSIButton9");  

	    public AuthenticationPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // give enough time
	    }

	    public void waitForYes() {
	        // Wait for redirect after user approves login on mobile
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(yesButton));
	    }


}
