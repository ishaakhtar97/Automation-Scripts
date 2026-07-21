package SynoptixAI.Pages;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleLogin extends SignUp{
	
	WebDriverWait wait;
	// Locators
	
	private By emailInput = By.xpath("//input[@name='email']");
	private By passwordInput = By.xpath("//input[@name='password']");
	private By nextBtn = By.xpath("//button[contains(text(),'Login')]");


	public SimpleLogin(WebDriver driver)
	{
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}


	public void login() throws InterruptedException 
	{
		waitForEmailVerification();
		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
		emailField.sendKeys(generatedEmail);
		//emailField.sendKeys("isha.akhtar@synoptix.ai");
		WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
		passField.sendKeys(password);
		//passField.sendKeys("Ish@nauman97");
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextButton.click();
		
		
	}
	
	
}
