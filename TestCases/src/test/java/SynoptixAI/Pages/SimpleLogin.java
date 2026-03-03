package SynoptixAI.Pages;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleLogin {
	WebDriver driver;
	WebDriverWait wait;
	private String generatedEmail; 
	private String password="Test@123";
	// Locators
	private By profileMenu = By.xpath("//div[contains(@class,'rounded-full') and contains(@class,'cursor-pointer')]");
	private By createAccountBtn = By.xpath("//button[normalize-space()='Create an Account']");
	private By loginBtn = By.xpath("//button[normalize-space()='Log in']");
	private By loginFormBtn = By.xpath("//button[normalize-space()='Login']");
	private By fullName  = By.xpath("//input[@id='fullName']");
	private By signupEmail  = By.xpath("//input[@id='email']");
	private By signupPassword  = By.xpath("//input[@id='password']");
	private By confirmPassword  = By.xpath("//input[@id='confirmPassword']");
	private By submit  = By.xpath("//button[normalize-space()='Create Account']");
	private By successMsg  = By.xpath("//div[contains(text(),'Account created successfully')]");
	private By emailInput = By.xpath("//input[@name='email']");
	private By resetEmailInput = By.xpath("//input[@type='email']");
	private By passwordInput = By.xpath("//input[@name='password']");
	private By nextBtn = By.xpath("//button[contains(text(),'Login')]");
	private By forgetBtn = By.xpath("//button[normalize-space()='Forgot password?']");
	private By resetBtn = By.xpath("//button[normalize-space()='Send reset email']");
	private By resetSuccess = By.xpath("//p[contains(text(),'Password reset email sent successfully')]");
	private By backToLogin = By.xpath("//button[normalize-space()='Back to login']");
	private By closeBtn = By.xpath("//button[contains(@class,'-top-3') and contains(@class,'-right-3')]");



	public SimpleLogin(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}


	private String generateRandomEmail()
	{
		generatedEmail= "synoptix.testuser" + UUID.randomUUID().toString().substring(0,3) + "@yopmail.com";

		System.out.println("Generated Email: " + generatedEmail);

		return generatedEmail;
	}

	// ✅ Create Account
	public void createAccount() 
	{

		generateRandomEmail();  // store email

		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(fullName)).sendKeys("Synoptix Test User");
		//wait.until(ExpectedConditions.elementToBeClickable(signupEmail)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signupEmail)).sendKeys(generatedEmail);
		//wait.until(ExpectedConditions.elementToBeClickable(signupPassword)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signupPassword)).sendKeys(password);
		//wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).click();
		wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		
	}
	
	public void forgetPasswd()
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginFormBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.elementToBeClickable(forgetBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(resetEmailInput)).sendKeys("isha.akhtar@synoptix.ai");
		wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(resetSuccess));
		
		
	}

	public void enterEmail(String LoginEmail) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(backToLogin)).click();
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
		emailField.sendKeys(LoginEmail);
	}

	// Actions
	public void enterPassword(String Loginpassword) {
		WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
		passField.sendKeys(Loginpassword);
	}


	public void Login() 
	{
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextButton.click();
		
		
	}
	
}
