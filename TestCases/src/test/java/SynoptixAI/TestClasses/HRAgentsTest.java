package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.ComplianceAgents;
import SynoptixAI.Pages.HRAgents;
import SynoptixAI.Setup.BaseSetup;

public class HRAgentsTest extends BaseSetup{
	
	HRAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new HRAgents(driver);    // Use global driver from BaseSetup

	}

	@Test (priority=81)
	public void draft_Offer_Letter_Agent() throws InterruptedException 
	{
		agents.checkOfferLetter();
		Thread.sleep(5000);
	}
	
	@Test (priority=82)
	public void hR_HelpDesk_Agent() throws InterruptedException 
	{
		agents.checkHelpDesk();
		Thread.sleep(5000);
	}
	
	@Test (priority=83)
	public void streamline_Benefits_and_Compensation_Agent() throws InterruptedException 
	{
		agents.checkBenefits();
		Thread.sleep(5000);
	}


}
