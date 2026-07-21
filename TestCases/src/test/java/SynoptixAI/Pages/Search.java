package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Search {
	WebDriver driver;
	WebDriverWait wait;
	
	private By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	private By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
	private By historyDropdown=By.xpath("(//h3[normalize-space()='Recent Chats']/following-sibling::button)[1]");
	private By firstChat=By.xpath("(//div[contains(@class,'group')])[1]");
	private By options=By.xpath("(//button[@title='More'])[1]");
	private By edit=By.xpath("//button[normalize-space()='Edit']");
	private By delete=By.xpath("//button[normalize-space()='Delete']");
	private By deleteBtn=By.xpath("//button[normalize-space()='Delete']");
	
	public Search(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	public void uploadFile(String filepath) throws InterruptedException 
	{

		
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
	
	public void goToFileWindow() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(newChatBtnLoc)).click();
	}
	
	public void editHistory() throws InterruptedException 
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(historyDropdown)).click();

		WebElement parentElement = driver.findElement(
			    By.xpath("(//div[contains(@class,'group')])[2]"));
			//parentElement.click();

			new Actions(driver).moveToElement(parentElement).perform();


		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentElement);

			// Now click More button
			WebElement moreBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//button[@title='More'])[1]")));

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(edit)).click();
		String originalTitle = parentElement.getText();
		
		 // Step 5: Input field appears
	    WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//input[@placeholder='Enter chat title']")
	    ));

	    // Append text
	    String appendedText = originalTitle + " Updated";

	    //inputBox.clear();
	    inputBox.sendKeys(appendedText);

	    // Step 6: Save (Enter key OR Save button)
	    inputBox.sendKeys(Keys.ENTER);
	    WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'updated')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Title not updated");
	}
	
	public void deleteHistory() throws InterruptedException 
	{
		

		// Step 1: find parent (chat row)
		WebElement parentElement = driver.findElement(
		    By.xpath("(//div[contains(@class,'group')])[2]"));
		//parentElement.click();

		new Actions(driver).moveToElement(parentElement).perform();

		// Now click More button
		WebElement moreBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("(//button[@title='More'])[1]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", moreBtn);
		wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

	    WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'deleted')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Title not updated");
	}
	
	
}
