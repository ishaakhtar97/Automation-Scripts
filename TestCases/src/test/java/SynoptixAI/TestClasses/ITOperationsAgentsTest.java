package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.ITOperationsAgents;
import SynoptixAI.Pages.SalesAgents;
import SynoptixAI.Setup.BaseSetup;

public class ITOperationsAgentsTest extends BaseSetup{
	
	ITOperationsAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new ITOperationsAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=10)
	public void it_HelpDesk_Agent() throws InterruptedException 
	{
		agents.checkITHelpdesk();
		Thread.sleep(5000);
	}
	
	@Test (priority=11)
	public void search_Latest_IT_Solutions_Agent() throws InterruptedException 
	{
		agents.checkLatestITSolutions();
		Thread.sleep(5000);
	}
	
}
