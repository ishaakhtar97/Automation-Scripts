package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PresentationBuilder {
	WebDriver driver;
	WebDriverWait wait;
	private By connections=By.cssSelector("img[alt='Connections']");
	private By tools=By.xpath("//button[normalize-space()='Tools']");
	private By pptCon=By.cssSelector("p[title='Design professional slides.']");
	private By addCon=By.xpath("(//button[normalize-space()='Add (1)'])[1]");
	private By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	private By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
	private By sendBtnLoc=By.cssSelector("img[alt='Send']");

	public PresentationBuilder(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(180));

	}

	public void turnOnPPTTool() {

		WebElement newChatBtn=wait.until(ExpectedConditions.elementToBeClickable(newChatBtnLoc));
		newChatBtn.click();
		WebElement conBtn = wait.until(ExpectedConditions.elementToBeClickable(connections));
		conBtn.click();
		WebElement toolBtn = wait.until(ExpectedConditions.elementToBeClickable(tools));
		toolBtn.click();
		WebElement pptBtn=wait.until(ExpectedConditions.elementToBeClickable(pptCon));	
		pptBtn.click();
		WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addCon));
		addBtn.click();
	}

	public void generatePPT() throws InterruptedException
	{

		WebElement promptField=driver.findElement(promptFieldLoc);
		promptField.click();
		promptField.sendKeys("Create 5 slide presentation on how climate change is affecting different continents.");
		WebElement sendButton=wait.until(ExpectedConditions.elementToBeClickable(sendBtnLoc));
		sendButton.click();
		 WebElement pptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Download and review']")));
	       // meetingLinkButton.click();
	        Assert.assertTrue(pptButton.isDisplayed(), "Presentation generated!");
	}



}
