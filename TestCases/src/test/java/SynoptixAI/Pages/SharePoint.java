package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SharePoint {
	WebDriver driver;
	WebDriverWait wait;

	private By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	private By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
	private By sendBtnLoc=By.cssSelector("img[alt='Send']");
	private By connections=By.cssSelector("img[alt='Connections']");
	private By sharePCon=By.xpath("(//span[normalize-space()='SharePoint'])[1]");
	private By addCon=By.xpath("(//button[normalize-space()='Add (1)'])[1]");


	public SharePoint(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	public void turnOnSharePointCon() {

		WebElement conBtn = wait.until(ExpectedConditions.elementToBeClickable(connections));
		conBtn.click();
		WebElement outlookBtn=wait.until(ExpectedConditions.elementToBeClickable(sharePCon));	
		outlookBtn.click();
		WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addCon));
		addBtn.click();
	}


	public void verifyOnlyPPTFilesFromSharePoint() throws InterruptedException
	{

		WebElement newChatBtn=wait.until(ExpectedConditions.elementToBeClickable(newChatBtnLoc));
		newChatBtn.click();
		WebElement promptField=driver.findElement(promptFieldLoc);
		promptField.click();
		promptField.sendKeys("Give me only PPT files existing on my SharePoint");
		WebElement sendButton=wait.until(ExpectedConditions.elementToBeClickable(sendBtnLoc));
		sendButton.click();
		
	}
}
