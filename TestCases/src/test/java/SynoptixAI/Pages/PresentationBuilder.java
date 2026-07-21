package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SynoptixAI.Setup.ToolsBaseSetup;

public class PresentationBuilder extends ToolsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	

	public PresentationBuilder(WebDriver driver) 
	{
		super(driver);

	}

	public void  checkPresentationTool() throws InterruptedException
	{
		String prompt="Generate a 5 slide presentation on Covid-19";
		//newChatWindow();
		turnOnTool("Presentation Builder");
		callTool("Presentation Builder",prompt);
	}



}
