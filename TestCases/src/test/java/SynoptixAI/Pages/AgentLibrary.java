package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgentLibrary {
	

	WebDriver driver;
	WebDriverWait wait;

	private By agentLibrary=By.xpath("//span[normalize-space()='Agent Library']");
	private By firstAgent=By.xpath("(//button[contains(text(),'Try Now')])[1]");
	private By deployAgent=By.xpath("//button[normalize-space()='Deploy']");

	
	
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
	}
	
	
	
	

}
