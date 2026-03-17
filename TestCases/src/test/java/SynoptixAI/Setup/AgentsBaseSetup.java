package SynoptixAI.Setup;

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

public class AgentsBaseSetup {


	WebDriver driver;
	WebDriverWait wait;

    protected By agentLibrary = By.xpath("//span[normalize-space()='Agent Library']");
    protected By responseLocator = By.xpath("//div[contains(@class,'text-[#475569]') and contains(@class,'leading-[28px]')]");
    protected By errorLocator = By.xpath("//div[contains(text(),'Server Is Busy Please Try Again')]");
    protected By likeBtn = By.xpath("//button[@title='Like']");
    protected By modelDropdwon = By.xpath("(//div[@type='button'])[1]");
    protected By modelGPT = By.xpath("//span[@class='flex-1'][normalize-space()='GPT 5.3']");

	public AgentsBaseSetup(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofMinutes(3));
	}
	public void validateAgentResponse(By agentCategoryDropDown,By agentSubCategory, String agentTitle, String innerCardTitle, boolean selectCategory) throws InterruptedException
	{
		WebElement agentLibBtn = wait.until(ExpectedConditions.elementToBeClickable(agentLibrary));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentLibBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", agentLibBtn);

		// Select categories
		if (selectCategory) {
			wait.until(ExpectedConditions.elementToBeClickable(agentCategoryDropDown)).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(agentSubCategory)).click();
			Thread.sleep(1000);
		}

		// Click Risk Detector Agent
		//By agentName = By.xpath("//div[./div/h3[@title='" + agentTitle + "']]//button[normalize-space()='Try Now']");
		By agentName = By.xpath("//div[./div/h3[contains(normalize-space(@title),normalize-space('" + agentTitle + "'))]]//button[normalize-space()='Try Now']");
		//By agentName = By.xpath("//h3[contains(normalize-space(.),'\" + agentTitle + \"')]/ancestor::div[contains(@class,'flex-col')][1]//button[normalize-space()='Try Now']");
		//By agentName = By.xpath("//h3[contains(.,'\" + agentTitle + \"')]/following::button[normalize-space()='Try Now'][1]");
		WebElement agentCard = wait.until(ExpectedConditions.visibilityOfElementLocated(agentName));
		agentCard.click();

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(modelDropdwon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(modelGPT)).click();
		Thread.sleep(1000);

		//WebElement tryNowBtn = wait.until(ExpectedConditions.elementToBeClickable(innerTryNow));
		By innerCardName = By.xpath("//h3[contains(normalize-space(@title),normalize-space('" + innerCardTitle + "'))]");
		WebElement cardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(innerCardName));

		WebElement card = cardTitle.findElement(By.xpath("./ancestor::div[contains(@class,'flex-col')][1]"));
		WebElement tryNowBtn = card.findElement(By.xpath(".//button[@id='try-now']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tryNowBtn);

		System.out.println("Try Now clicked successfully");

		// Ensure something actually happens
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(responseLocator),
				ExpectedConditions.visibilityOfElementLocated(errorLocator)
				));

		System.out.println("Waiting for response or error...");
		try {

			Boolean result = wait.until(driver1 -> {

				// ---- CHECK RESPONSE ----
				List<WebElement> responses = driver1.findElements(responseLocator);
				List<WebElement> likes = driver1.findElements(likeBtn);

				if (!responses.isEmpty()) {

					String responseText = responses.get(0).getText().trim();

					boolean validText = responseText.length() > 10 && !responseText.equalsIgnoreCase("Server Is Busy Please Try Again");

					boolean likeVisible =!likes.isEmpty() && likes.get(0).isDisplayed();

					if (validText && likeVisible) {
						System.out.println("VALID RESPONSE FOUND");
						return true;
					}
				}

				// ---- CHECK ERROR ----
				List<WebElement> errors = driver1.findElements(errorLocator);
				if (!errors.isEmpty()) {
					throw new RuntimeException(
							"Agent returned error: " + errors.get(0).getText().trim());
				}

				return false;
			});

			Assert.assertTrue(result, "Agent returned a valid response.");

		} catch (TimeoutException e) {
			Assert.fail("No response OR error received even after timeout.");
		}
	}


}
