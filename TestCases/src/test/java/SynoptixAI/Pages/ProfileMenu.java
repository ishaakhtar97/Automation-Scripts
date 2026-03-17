package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfileMenu  {

	WebDriver driver;
	WebDriverWait wait;
	
	public ProfileMenu(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	// Locators
	private By profileMenu = By.xpath("//div[contains(@class,'rounded-full') and contains(@class,'cursor-pointer')]");
	private By reportBug = By.xpath("//span[normalize-space()='Report a Bug']");
	private By giveAIInstructions = By.xpath("//span[normalize-space()='Give AI Instructions']");
	private By bugDesc = By.xpath("//textarea[@id='description']");
	//private By uploadDocBtn = By.xpath("//button[normalize-space()='Browse File']");
	private By submit = By.xpath("//button[normalize-space()='Submit Bug Report']");
	private By instructions = By.xpath("//textarea[@id='instruction']");
	private By addBtn = By.xpath("//button[normalize-space()='Add']");
	private By closeBtn = By.xpath("//button[contains(@class,'-top-3') and contains(@class,'-right-3')]");


	public void reportBug(String filepath)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(reportBug)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bugDesc)).sendKeys("Issue faced when login, Image attached");
		//wait.until(ExpectedConditions.elementToBeClickable(uploadDocBtn)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(uploadDocBtn)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(uploadDocFromDevice)).click();
		// Step 2: Locate input type=file
       /* WebElement fileInput = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

        // Step 3: Upload ONE file
        fileInput.sendKeys(filepath);*/
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
        WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'Successfully') or contains(text(),'successfully')]")));
				Assert.assertTrue(successToast.isDisplayed(),"Bug not reported");
		
		
	}
	public void aiInsctructions()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(giveAIInstructions)).click();
		wait.until(ExpectedConditions.elementToBeClickable(instructions)).sendKeys("You are an AI agent who will help me in everything");
		wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
		 WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'Successfully') or contains(text(),'successfully')]")));
					Assert.assertTrue(successToast.isDisplayed(),"Instructions not added");
	}
	
	

}