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

public class MarketingAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	
	private By agentDropDown=By.xpath("//span[normalize-space()='Legal' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Marketing')]");
	

	public MarketingAgents(WebDriver driver) 
	{
		super(driver);
		
	}
	public void checkBlogGenerator() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Blog generator","Suggest blog topics from market trends",true);

	}
	
	public void checkCreateBOM() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Create","Create marketing BOM for new product launch",false);
		
	}

	public void checkEmail() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Email marketing agent","Write a campaign outreach email",false);
	}
	
	public void checkStreamline() throws InterruptedException 
	{
		
		validateAgentResponse(agentDropDown,agentCategory,"Streamline market research and strategy","Digital marketing trends 2025",false);
	}

	
}




