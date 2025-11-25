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

public class MarketingAgents {

	WebDriver driver;
	WebDriverWait wait;

	//private By home=By.xpath("//span[contains(@class,'text-sm font-medium')]");
	private By home=By.xpath("//img[@class='object-contain']");
	private By agentLibrary=By.xpath("//span[normalize-space()='Agent Library']");
	private By agentCategory=By.xpath("//span[normalize-space()='All Teams']");
	private By marketingCategory=By.xpath("//button[contains(text(),'Marketing')]");
	private By blogGenerator=By.xpath("(//button[contains(text(),'Try Now')])[3]");
	private By createBOMAgent=By.xpath("(//button[contains(text(),'Try Now')])[1]");
	private By streamlineAgent=By.xpath("(//button[contains(text(),'Try Now')])[2]");
	private By emailAgent=By.xpath("(//button[contains(text(),'Try Now')])[4]");
	private By responseLocator = By.xpath("//div[contains(@class,'font-normal') and contains(@class,'mb-3')]");
	//private By responseLocator = By.xpath("(//div[contains(@class,'text')])[10]");
	private By errorLocator = By.xpath("//div[contains(text(),'Server Is Busy Please Try Again')]");




	public MarketingAgents(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofMinutes(3));
	}

	public void checkCreateBOM() throws InterruptedException 
	{
		// Go Home
		WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(home));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBtn);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeBtn);

		// Agent Library Flow
		wait.until(ExpectedConditions.elementToBeClickable(agentLibrary)).click();
		wait.until(ExpectedConditions.elementToBeClickable(agentCategory)).click();
		wait.until(ExpectedConditions.elementToBeClickable(marketingCategory)).click();

		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(createBOMAgent)).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//button[contains(text(),'Try now →')])[1]"))).click();


		System.out.println("Waiting for response or error...");


		// **************  SMART WAIT STARTS HERE  **************
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

					// ✔ response container found — wait until actual text comes
					if (text.length() > 5 && 
							!text.equalsIgnoreCase("Server Is Busy Please Try Again"))
					{
						System.out.println("VALID RESPONSE FOUND: " + text);
						return true;   // PASS and stop waiting
					}
				}

				// ----- CHECK FOR ERROR -----
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false;   // keep waiting until timeout
			});

			// If we reached here → Valid response received
			Assert.assertTrue(result, "Agent returned a valid response");

		} catch (TimeoutException e) {

			Assert.fail(" No response OR error received even after 3 mins.");
		}
		
		
		/*WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(home));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBtn);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeBtn);
		//homeBtn.click();
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		agentLibBtn.click();
		WebElement categoryLOV = wait.until(ExpectedConditions.elementToBeClickable(agentCategory));
		categoryLOV.click();
		WebElement categoryMarketing = wait.until(ExpectedConditions.elementToBeClickable(marketingCategory));
		categoryMarketing.click();
		Thread.sleep(2000);
		WebElement bomAgent = wait.until(ExpectedConditions.elementToBeClickable(createBOMAgent));
		bomAgent.click();
		Thread.sleep(1000);
		WebElement blogGeneratorPrompt = wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("(//button[contains(text(),'Try now →')])[1]")));
		blogGeneratorPrompt.click();
		try {
			// 👀 Wait until EITHER response or error appears
			wait.until(driver1 -> 
			{
				boolean hasResponse = !driver1.findElements(responseLocator).isEmpty();
				boolean hasError = !driver1.findElements(errorLocator).isEmpty();

				// If valid response appears → PASS immediately
				if (hasResponse) {
					String text = driver1.findElement(responseLocator).getText().trim();

					if (!text.equalsIgnoreCase("Server Is Busy Please Try Again")) {
						System.out.println("Valid Response Found " );//+ text);
						return true; // stop waiting
					}
				}

				// If error appears → trigger fail
				if (hasError) {
					Assert.fail("Agent returned error: Server Is Busy Please Try Again");
				}

				return false; // continue waiting
			});

			// If reached here: response was valid
			Assert.assertTrue(true, "Agent working correctly — valid response received.");

		} catch (TimeoutException e) {
			Assert.fail("No response OR error received even after 3 minutes. Agent may be stuck.");
		}*/
	}


	public void checkBlogGenerator() throws InterruptedException 
	{
		// Scroll & Open Agent Library
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		Thread.sleep(3000);
		//agentLibBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);
		// Open Blog Generator Agent
		WebElement blogGeneratorAgent = wait.until(ExpectedConditions.elementToBeClickable(blogGenerator));
		blogGeneratorAgent.click();
		Thread.sleep(1500);

		// Click "Try now"
		WebElement blogGeneratorPrompt = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Try now →')])[1]"))
				);
		blogGeneratorPrompt.click();

		System.out.println("Waiting for response or error...");

		try {

			Boolean result = wait.until(driver1 -> {

				// WAIT FOR RESPONSE LIST (refreshed to avoid stale element)
				List<WebElement> responses = wait.until(
						ExpectedConditions.refreshed(
								ExpectedConditions.visibilityOfAllElementsLocatedBy(responseLocator)
								)
						);

				if (!responses.isEmpty()) {
					String text = responses.get(0).getText().trim();

					// valid response
					if (text.length() > 5 &&
							!text.equalsIgnoreCase("Server Is Busy Please Try Again")) {

						System.out.println("VALID RESPONSE FOUND: " + text);
						return true;  // STOP WAIT HERE
					}
				}

				// CHECK FOR ERROR
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false; // continue waiting
			});

			Assert.assertTrue(result, "Agent returned a valid response");

		} catch (TimeoutException e) {
			Assert.fail("No response OR error received even after 3 minutes. Agent may be stuck.");
		}

	}

	public void checkStreamline() throws InterruptedException 
	{
		// Go to Agent Library
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);

		// Open Streamline Research Agent
		WebElement streamlineReserachAgent = wait.until(ExpectedConditions.elementToBeClickable(streamlineAgent));
		streamlineReserachAgent.click();

		Thread.sleep(2000);

		// Click Try Now button
		WebElement tryNowBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//button[contains(text(),'Try now →')])[1]")));
		tryNowBtn.click();

		System.out.println("Waiting for response or error...");

		// ************** SMART WAIT STARTS HERE **************
		try {

			Boolean result = wait.until(driver1 -> {

				// ---- CHECK IF RESPONSE ELEMENT EXISTS ----
				List<WebElement> responses = wait.until(
						ExpectedConditions.refreshed(
								ExpectedConditions.visibilityOfAllElementsLocatedBy(responseLocator)
								)
						);

				if (!responses.isEmpty()) {

					String text = responses.get(0).getText().trim();

					// ✔ VALID RESPONSE FOUND
					if (text.length() > 5 &&
							!text.equalsIgnoreCase("Server Is Busy Please Try Again"))
					{
						System.out.println("VALID RESPONSE FOUND: " + text);
						return true; // PASS immediately
					}
				}

				// ---- CHECK IF ERROR APPEARS ----
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false; // Continue waiting
			});

			// If reached here → Valid response received
			Assert.assertTrue(result, "Agent returned a valid response");

		} 
		catch (TimeoutException e) {
			Assert.fail("No response OR error received even after 3 minutes.");
		}


	}

	public void checkEmail() throws InterruptedException 
	{
		// Go to Agent Library
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);

		// Open Email Marketing Agent
		WebElement emailMarketAgent = wait.until(ExpectedConditions.elementToBeClickable(emailAgent));
		emailMarketAgent.click();

		Thread.sleep(2000);

		// Click Try Now
		WebElement tryNowBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//button[contains(text(),'Try now →')])[1]")));
		tryNowBtn.click();

		System.out.println("Waiting for response or error...");

		// ************** SMART WAIT STARTS HERE **************
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

					// ✔ VALID RESPONSE FOUND
					if (text.length() > 5 && 
							!text.equalsIgnoreCase("Server Is Busy Please Try Again"))
					{
						System.out.println("VALID RESPONSE FOUND: " + text);
						return true;    // PASS immediately
					}
				}

				// ---- CHECK FOR ERROR ----
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					String errText = errors.get(0).getText();
					Assert.fail("Agent returned ERROR: " + errText);
				}

				return false;   // Continue waiting
			});

			// If reached here → Valid response received
			Assert.assertTrue(result, "Agent returned a valid response");

		} catch (TimeoutException e) {

			Assert.fail("No response OR error received even after 3 minutes.");
		}
	

	}
}




