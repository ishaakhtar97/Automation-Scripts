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

public class SalesAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	
	private By agentDropDown=By.xpath("//span[normalize-space()='Researcher' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Sales')]");

	public SalesAgents(WebDriver driver) 
	{
	super(driver);
	}
	
	public void checkContractSummariser() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Contract summariser","Summarise key terms in uploaded contract",true);
	}
	
	
	public void checkSalesIntelligence() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Sales intelligent agent","Identify engagement talking points",false);
		
	}
}
