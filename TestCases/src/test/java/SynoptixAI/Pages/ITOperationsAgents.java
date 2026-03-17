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

public class ITOperationsAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	
	private By agentDropDown=By.xpath("//span[normalize-space()='HR and Recruitment' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'IT Operations')]");
	
	public ITOperationsAgents(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void checkITHelpdesk() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"IT help desk","Resolve azure blob access denied issue",true);
	}
	
	public void checkLatestITSolutions() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Search latest IT","Describe key requirements for IT solutions",false);
	}
}
