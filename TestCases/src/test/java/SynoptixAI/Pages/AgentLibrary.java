package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AgentLibrary {


	WebDriver driver;
	WebDriverWait wait;

	private By agentLibrary=By.xpath("//span[normalize-space()='Agent Library']");
	private By firstAgent=By.xpath("(//button[contains(text(),'Try Now')])[2]");
	private By deployAgent=By.xpath("//button[normalize-space()='Deploy']");
	private By addFileBtn=By.xpath("//button[@title='Add files']//*[name()='svg']");
	private By uploadBtn=By.xpath("//img[@alt='thoughts']");



	public AgentLibrary(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void agentDeploy() throws InterruptedException 
	{
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		agentLibBtn.click();
		WebElement tryBtn = wait.until(ExpectedConditions.elementToBeClickable(firstAgent));
		tryBtn.click();
		Thread.sleep(2000);
		WebElement deployBtn = wait.until(ExpectedConditions.elementToBeClickable(deployAgent));
		deployBtn.click();
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'deployed')")
					));

			System.out.println("Agent deployed " + successToast.getText());

		} catch (Exception e) {
			System.out.println("Agent may not get deployed");
		}
		wait.until(ExpectedConditions.elementToBeClickable(agentLibrary)).click();
	}

	public void uploadFile(String filepath) throws InterruptedException 
	{

		//wait.until(ExpectedConditions.elementToBeClickable(addFileBtn)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(uploadBtn)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(uploadBtn)).click();
		WebElement fileInput = wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath("//input[@type='file']")
						));

		// Step 3: Upload ONE file
		fileInput.sendKeys(filepath);
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'Successfully') or contains(text(),'processed successfully')]")));
		Assert.assertTrue(successToast.isDisplayed(),"File uploading failed");


	}

	public void goToAgentWindow() throws InterruptedException 
	{
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		agentLibBtn.click();
		WebElement tryBtn = wait.until(ExpectedConditions.elementToBeClickable(firstAgent));
		tryBtn.click();
		Thread.sleep(2000);
	}


}
