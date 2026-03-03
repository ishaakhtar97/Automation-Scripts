package SynoptixAI.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import SynoptixAI.Setup.AgentsBaseSetup;

public class ComplianceAgents extends AgentsBaseSetup {
	WebDriver driver;
	WebDriverWait wait;

	private By agentDropDown=By.xpath("//span[normalize-space()='All Teams']");
	private By agentCategory=By.xpath("//button[contains(text(),'Compliance')]");


	public ComplianceAgents(WebDriver driver) {
		super(driver);
	}

	public void checkRiskDetector() throws InterruptedException 
	{

		validateAgentResponse(agentDropDown,agentCategory,"Compliance risk detector","Review compliance gaps for internal policies",true);

	}

	public void checkTrainingAgent() throws InterruptedException 
	{
		validateAgentResponse(agentDropDown,agentCategory,"Compliance training assistant","Data protection and privacy training module",false);

	}

	public void checkThirdPartyAgent() throws InterruptedException 
	{
		validateAgentResponse(agentCategory,agentCategory,"Third-party compliance agent","Provide general vendor risk checklist",false);

	}

	
}

