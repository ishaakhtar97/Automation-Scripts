package SynoptixAI.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Evaluations {
	WebDriver driver;
	WebDriverWait wait;

	private By mgmntCentre=By.xpath("//span[normalize-space()='Management Center']");
	private By evalPage=By.xpath("//span[normalize-space()='Evaluations']");


	public Evaluations(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}


	public void checkLatencyGraph() throws InterruptedException
	{
		WebElement mngmntMenu = wait.until(ExpectedConditions.elementToBeClickable(mgmntCentre));
		mngmntMenu.click();
		Thread.sleep(1000);
		WebElement evaluationsPage = wait.until(ExpectedConditions.elementToBeClickable(evalPage));
		evaluationsPage.click();
		Thread.sleep(1000);
		// 1️⃣ Wait for Latency graph container
		WebElement graphContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'])[7]")));
		Assert.assertTrue(graphContainer.isDisplayed(), "Latency graph container is not displayed!");
		List<WebElement> bars = driver.findElements(
				By.xpath("//p[contains(text(),'Latency')][1]]//g[contains(@class,'recharts-bar-rectangle')]/*[name()='path']")
				);

		System.out.println("Bars found: " + bars.size());

	}

}
