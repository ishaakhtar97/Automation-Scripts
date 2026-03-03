package SynoptixAI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import SynoptixAI.Setup.AgentsBaseSetup;

public class GeneralAgents extends AgentsBaseSetup {
	WebDriver driver;
	WebDriverWait wait;

	private By agentDropDown=By.xpath("//span[normalize-space()='Finance' or normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'General')]");


	public GeneralAgents(WebDriver driver) {
		super(driver);
	}

	public void checkProcess() throws InterruptedException 
	{

		validateAgentResponse(agentDropDown,agentCategory,"Process generator","Generate employee onboarding process map",true);

	}

	public void checkSpreadsheet() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Spreadsheet assistant","Generate common formulas for analysis",false);

	}

	

}
