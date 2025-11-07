package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ImageGeneration {
	WebDriver driver;
	WebDriverWait wait;
	private By connections=By.cssSelector("img[alt='Connections']");
	private By tools=By.xpath("//button[normalize-space()='Tools']");
	private By imgCon=By.cssSelector("p[title='Generate images from text prompts.']");
	private By addCon=By.xpath("(//button[normalize-space()='Add (1)'])[1]");
	private By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	private By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
	private By sendBtnLoc=By.cssSelector("img[alt='Send']");

	public ImageGeneration(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
}
	public void turnOnImageTool() {

		WebElement newChatBtn=wait.until(ExpectedConditions.elementToBeClickable(newChatBtnLoc));
		newChatBtn.click();
		WebElement conBtn = wait.until(ExpectedConditions.elementToBeClickable(connections));
		conBtn.click();
		WebElement toolBtn = wait.until(ExpectedConditions.elementToBeClickable(tools));
		toolBtn.click();
		WebElement imgBtn=wait.until(ExpectedConditions.elementToBeClickable(imgCon));	
		imgBtn.click();
		WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addCon));
		addBtn.click();
	}

	public void generateImage() throws InterruptedException
	{

		WebElement promptField=driver.findElement(promptFieldLoc);
		promptField.click();
		promptField.sendKeys("Generate a realistic oil painting of mountains and rivers.");
		WebElement sendButton=wait.until(ExpectedConditions.elementToBeClickable(sendBtnLoc));
		sendButton.click();
		WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Realistic oil painting of mountains and rivers']")));
		// Step 5: Validate chart presence
		Assert.assertTrue(image.isDisplayed(), "Image is not generated.");
	}
	
	}
