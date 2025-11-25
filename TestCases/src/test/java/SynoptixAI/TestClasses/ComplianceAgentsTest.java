package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.ComplianceAgents;
import SynoptixAI.Setup.BaseSetup;

public class ComplianceAgentsTest extends BaseSetup{
	
	ComplianceAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new ComplianceAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=70)
	public void compliance_Risk_Detector_Agent() throws InterruptedException 
	{
		agents.checkRiskDetector();
		Thread.sleep(5000);
	}

	@Test (priority=71)
	public void complaince_Training_Assistant_Agent() throws InterruptedException 
	{
		agents.checkTrainingAgent();
		Thread.sleep(5000);
	}
	
	@Test (priority=72)
	public void third_Party_Compliance_Agent() throws InterruptedException 
	{
		agents.checkThirdPartyAgent();
		Thread.sleep(5000);
	}
	
	

}
