package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.ComplianceAgents;
import SynoptixAI.Pages.GeneralAgents;
import SynoptixAI.Setup.BaseSetup;

public class GeneralAgentsTest extends BaseSetup{
	
	GeneralAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new GeneralAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=70)
	public void process_Generator_Agent() throws InterruptedException 
	{
		agents.checkProcess();
		Thread.sleep(5000);
	}

	@Test (priority=71)
	public void spreadsheet_assitant_Agent() throws InterruptedException 
	{
		agents.checkSpreadsheet();
		Thread.sleep(5000);
	}

}
