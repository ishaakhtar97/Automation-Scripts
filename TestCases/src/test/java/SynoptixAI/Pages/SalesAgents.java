package SynoptixAI.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SalesAgents {
	WebDriver driver;
	WebDriverWait wait;

	//private By home=By.xpath("//span[contains(@class,'text-sm font-medium')]");
	private By agentLibrary=By.xpath("//span[normalize-space()='Agent Library']");
	private By agentCategory=By.xpath("//span[normalize-space()='Project Management' or normalize-space()='All Teams']");
	private By salesCategory=By.xpath("//button[contains(text(),'Sales')]");
	private By contractSummAgent=By.xpath("(//button[contains(text(),'Try Now')])[1]");
	private By leadQualAgent=By.xpath("(//button[contains(text(),'Try Now')])[2]");
	private By salesIntelligentAgent=By.xpath("(//button[contains(text(),'Try Now')])[3]");
	private By responseLocator = By.xpath("//div[contains(@class,'font-normal') and contains(@class,'mb-3')]");
	private By errorLocator = By.xpath("//div[contains(text(),'Server Is Busy Please Try Again')]");
	

	public SalesAgents(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofMinutes(3));
	}
	
	public void checkContractSummariser() throws InterruptedException 
	{
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		Thread.sleep(5000);
		//agentLibBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);
		// Select categories
		wait.until(ExpectedConditions.elementToBeClickable(agentCategory)).click();
		wait.until(ExpectedConditions.elementToBeClickable(salesCategory)).click();

		Thread.sleep(2000);

		// Click Code Debug Agent
		wait.until(ExpectedConditions.elementToBeClickable(contractSummAgent)).click();

		Thread.sleep(1000);

		// Click Try Now
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//button[contains(text(),'Try now →')])[1]"))).click();

		System.out.println("Waiting for response or error...");

		// ************** SMART WAIT **************
		try {

			Boolean result = wait.until(driver1 -> {

				// ---- CHECK FOR RESPONSE ----
				List<WebElement> responses = wait.until(
						ExpectedConditions.refreshed(
								ExpectedConditions.visibilityOfAllElementsLocatedBy(responseLocator)
								)
						);

				if (!responses.isEmpty()) {
					String text = responses.get(0).getText().trim();

					if (text.length() > 5 &&
							!text.equalsIgnoreCase("Server Is Busy Please Try Again"))
					{
						System.out.println("VALID RESPONSE FOUND: " + text);
						return true;     // PASS
					}
				}

				// ---- CHECK FOR ERROR ----
				List<WebElement> errors = driver1.findElements(errorLocator);

				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false; // keep waiting

			});

			Assert.assertTrue(result, "Agent returned a valid response.");

		} catch (TimeoutException e) {
			Assert.fail("No response OR error received even after 3 minutes.");
		}
	}
	
	public void checkLeadQualification() throws InterruptedException 
	{

		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		Thread.sleep(5000);
		//agentLibBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);

		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(leadQualAgent)).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//button[contains(text(),'Try now →')])[1]"))).click();


		System.out.println("Waiting for response or error...");

		// ************** SMART WAIT STARTS HERE **************
		try {

			Boolean result = wait.until(driver1 -> {

				// ----- CHECK IF RESPONSE ELEMENT EXISTS -----
				List<WebElement> responses = wait.until(
						ExpectedConditions.refreshed(
								ExpectedConditions.visibilityOfAllElementsLocatedBy(responseLocator)
								)
						);

				if (!responses.isEmpty()) {
					String text = responses.get(0).getText().trim();

					// ✔ response container found — ensure actual text is meaningful
					if (text.length() > 5 &&
							!text.equalsIgnoreCase("Server Is Busy Please Try Again"))
					{
						System.out.println("VALID RESPONSE FOUND: " + text);
						return true;  // PASS
					}
				}

				// ----- CHECK IF ERROR ELEMENT EXISTS -----
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false;  // continue waiting

			});

			// ✔ Valid response received
			Assert.assertTrue(result, "Agent returned a valid response");

		} catch (TimeoutException e) {

			Assert.fail("No response OR error received even after 3 minutes. Agent may be stuck.");
		}
	}
	
	public void checkSalesIntelligence() throws InterruptedException 
	{

		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		Thread.sleep(5000);
		//agentLibBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);

		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(salesIntelligentAgent)).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//button[contains(text(),'Try now →')])[1]"))).click();


		System.out.println("Waiting for response or error...");

		// ************** SMART WAIT STARTS HERE **************
		try {

			Boolean result = wait.until(driver1 -> {

				// ----- CHECK IF RESPONSE ELEMENT EXISTS -----
				List<WebElement> responses = wait.until(
						ExpectedConditions.refreshed(
								ExpectedConditions.visibilityOfAllElementsLocatedBy(responseLocator)
								)
						);

				if (!responses.isEmpty()) {
					String text = responses.get(0).getText().trim();

					// ✔ response container found — ensure actual text is meaningful
					if (text.length() > 5 &&
							!text.equalsIgnoreCase("Server Is Busy Please Try Again"))
					{
						System.out.println("VALID RESPONSE FOUND: " + text);
						return true;  // PASS
					}
				}

				// ----- CHECK IF ERROR ELEMENT EXISTS -----
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false;  // continue waiting

			});

			// ✔ Valid response received
			Assert.assertTrue(result, "Agent returned a valid response");

		} catch (TimeoutException e) {

			Assert.fail("No response OR error received even after 3 minutes. Agent may be stuck.");
		}
	}
}
