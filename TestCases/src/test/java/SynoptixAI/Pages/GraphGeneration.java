package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GraphGeneration {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 private By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	 private By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
		private By sendBtnLoc=By.cssSelector("img[alt='Send']");
	 
	 public GraphGeneration(WebDriver driver) {
			this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			}
	 public void generateGraph() throws InterruptedException
	 {
		 
		 	WebElement newChatBtn=wait.until(ExpectedConditions.elementToBeClickable(newChatBtnLoc));
		 	newChatBtn.click();
		    WebElement promptField=driver.findElement(promptFieldLoc);
			promptField.click();
			promptField.sendKeys("Create a bar chart showing sales of laptops  700, mobiles 500, and tablets 150  for Q1");
			WebElement sendButton=wait.until(ExpectedConditions.elementToBeClickable(sendBtnLoc));
			sendButton.click();
			WebElement chart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("canvas[role='img']")));
			// Step 5: Validate chart presence
		    Assert.assertTrue(chart.isDisplayed(), "Bar chart is not displayed.");
	 }
	 
	 
	 

}

