package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SynoptixAI.Setup.ToolsBaseSetup;

public class LinkedIn extends ToolsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	

	public LinkedIn(WebDriver driver) 
	{
		super(driver);

	}

	public void  checkLinkedInTool() throws InterruptedException
	{
		String prompt="";
		//newChatWindow();
		turnOnTool("LinkedIn Post Creator");
		callTool("LinkedIn",prompt);
	}

	

}
