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

public class ResearcherAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	
	private By agentDropDown=By.xpath("//span[normalize-space()='Project Management' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Researcher')]");
	
	public ResearcherAgents(WebDriver driver) {
		super(driver);
	}	

	public void checkMarketCompetitor() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Competitor analysis","Competitive landscape review – Cloud SaaS market",true);
	}
	

	public void checkTrendsAnalyst() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Trends analyst","Global tech trends by growth impact",false);
	}

}
