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

public class HRAgents extends AgentsBaseSetup{
	
	WebDriver driver;
	WebDriverWait wait;

	private By agentDropDown=By.xpath("//span[normalize-space()='General' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'HR and Recruitment')]");

	

	public HRAgents(WebDriver driver) {
		super(driver);
	}
	

	public void checkOfferLetter() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Draft offer letter","Generate professional offer letter",true);
	
	}
	
	public void checkHelpDesk() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"HR helpdesk","Understand leave entitlements",false);
	
	}
	
	public void checkBenefits() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Streamline benefits & compensation","Compare salary benchmarks for a job role",false);
	}
}
