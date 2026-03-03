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

public class LegalAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	
	private By agentDropDown=By.xpath("//span[normalize-space()='IT Operations' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Legal')]");


	public LegalAgents(WebDriver driver) {
		super(driver);
	}
	
	public void checkExtractLegal() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Extract legal facts","Extract key facts and opinions from agreement",true);
	}
	

	public void checkGuidance() throws InterruptedException 
	{

		validateAgentResponse(agentDropDown,agentCategory,"Legal guidance","Search Australian precedents on unfair dismissal",false);
	}
	
	public void checkLegalStrategy() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Legal strategy development","Identidy legal issues and defences from case data",false);
	}

	
}
