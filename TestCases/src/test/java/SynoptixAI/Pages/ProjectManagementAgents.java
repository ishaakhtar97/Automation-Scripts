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

public class ProjectManagementAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	
	private By agentDropDown=By.xpath("//span[normalize-space()='Marketing' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Project Management')]");
	


	public ProjectManagementAgents(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void checkGovernance() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Project governance agent","Check project governance readiness",true);
	}
	
	public void checkRiskAssessment() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Risk assessment","Evaluate early-stage project uncertainties",false);
	}
	
}
