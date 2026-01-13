package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginOptionsPage {
	
	WebDriver driver;
	WebDriverWait wait;
    // Locators
	private By googleBtn=By.xpath("//button[normalize-space()='Continue with Google']");
   
 
   public LoginOptionsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
    
   public void loginWithGoogle() {
       WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(googleBtn));
       emailField.click();
   }

}
