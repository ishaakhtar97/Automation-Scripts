package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SynoptixAI.Setup.ToolsBaseSetup;

public class ImageGeneration extends ToolsBaseSetup{

	WebDriver driver;
	WebDriverWait wait;

	public ImageGeneration(WebDriver driver) 
	{
		super(driver);

	}

	public void  checkImageGenerationTool() throws InterruptedException
	{
		String prompt="Generate me an Image of Dolphin";
		newChatWindow();
		turnOnTool("Image Generator");
		callTool("Image Generator",prompt);
	}
}