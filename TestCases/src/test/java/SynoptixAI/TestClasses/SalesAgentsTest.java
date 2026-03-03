package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.ProjectManagementAgents;
import SynoptixAI.Pages.SalesAgents;
import SynoptixAI.Setup.BaseSetup;

public class SalesAgentsTest extends BaseSetup{
	
	SalesAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new SalesAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=100)
	public void contract_Summariser_Agent() throws InterruptedException 
	{
		agents.checkContractSummariser();
		Thread.sleep(5000);
	}

	@Test (priority=102)
	public void sales_Intelligent_Agent() throws InterruptedException 
	{
		agents.checkSalesIntelligence();
		Thread.sleep(5000);
	}
	
	
}
