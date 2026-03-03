package SynoptixAI.Pages;


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

import SynoptixAI.Setup.AgentsBaseSetup;

public class DeveloperAgents extends AgentsBaseSetup {
	WebDriver driver;
	WebDriverWait wait;

	private By agentDropDown=By.xpath("//span[normalize-space()='Compliance' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Developer')]");


	public DeveloperAgents(WebDriver driver) {
		super(driver);
	}
	public void checkCodeDebug() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Code debug agent","Debug crashing web scraper with requests",true);
	}


	public void checkCodeGenerator() throws InterruptedException 
	{

		validateAgentResponse(agentDropDown,agentCategory,"Code generator","Export outlook email subjects to CSV",false);

	}
	
}
