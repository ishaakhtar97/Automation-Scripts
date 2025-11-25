package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.DeveloperAgents;
import SynoptixAI.Pages.MarketingAgents;
import SynoptixAI.Setup.BaseSetup;

public class DeveloperAgentsTest extends BaseSetup{
	
	DeveloperAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new DeveloperAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=40)
	public void code_Debug_Agent() throws InterruptedException 
	{
		agents.checkCodeDebug();
		Thread.sleep(5000);
	}

	@Test (priority=41)
	public void code_Generator_Agent() throws InterruptedException 
	{
		agents.checkCodeGenerator();
		Thread.sleep(5000);
	}


}
