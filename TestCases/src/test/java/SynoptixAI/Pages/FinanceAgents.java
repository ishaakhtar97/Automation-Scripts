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

public class FinanceAgents extends AgentsBaseSetup{
	WebDriver driver;
	WebDriverWait wait;
	private By agentDropDown=By.xpath("//span[normalize-space()='Developer' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Finance')]");


	public FinanceAgents(WebDriver driver) {
		super(driver);
	}
	public void checkAccountingDoc() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Accounting document evaluation","Finance files integrity review",true);

	}
	public void checkEOMAccruals() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Finance EoM accruals","Identify uninvoiced expense report",false);

	}

	public void checkFinanceManagement() throws InterruptedException 
	{

		validateAgentResponse(agentDropDown,agentCategory,"Finance management guidebook","Corporate financial management best practices",false);
	}

	public void checkAnamolyDetectorAgent() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Financial anomaly detector","Expense spike detection",false);
	}
}
