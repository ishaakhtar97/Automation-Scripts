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
	@Test (priority=110)
	public void access_Request_Assistant_Agent() throws InterruptedException 
	{
		agents.checkAccessRequest();
		Thread.sleep(5000);
	}

	@Test (priority=1011)
	public void it_HelpDesk_Agent() throws InterruptedException 
	{
		agents.checkITHelpdesk();
		Thread.sleep(5000);
	}
	
	@Test (priority=112)
	public void search_Latest_IT_Solutions_Agent() throws InterruptedException 
	{
		agents.checkLatestITSolutions();
		Thread.sleep(5000);
	}
	
}
