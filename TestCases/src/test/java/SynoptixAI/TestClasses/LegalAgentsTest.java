package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.LegalAgents;
import SynoptixAI.Setup.BaseSetup;

public class LegalAgentsTest extends BaseSetup{
	
	LegalAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new LegalAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=60)
	public void legal_Strategy_Development_Agent() throws InterruptedException 
	{
		agents.checkLegalStrategy();
		Thread.sleep(5000);
	}

	@Test (priority=61)
	public void quicker_Legal_Guidance_Agent() throws InterruptedException 
	{
		agents.checkQuickerLegal();
		Thread.sleep(5000);
	}
	
	@Test (priority=62)
	public void review_Legal_Document_Agent() throws InterruptedException 
	{
		agents.checkReviewLegal();
		Thread.sleep(5000);
	}
	
	@Test (priority=63)
	public void extract_Legal_Facts_Agent() throws InterruptedException 
	{
		agents.checkExtractLegal();
		Thread.sleep(5000);
	}

}
