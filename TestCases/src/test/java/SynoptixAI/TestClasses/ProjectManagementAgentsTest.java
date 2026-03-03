package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.HRAgents;
import SynoptixAI.Pages.ProjectManagementAgents;
import SynoptixAI.Setup.BaseSetup;

public class ProjectManagementAgentsTest extends BaseSetup{
	
	ProjectManagementAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new ProjectManagementAgents(driver);    // Use global driver from BaseSetup

	}
	
	
	@Test (priority=91)
	public void project_Governance_Agent() throws InterruptedException 
	{
		agents.checkGovernance();
		Thread.sleep(5000);
	}

	@Test (priority=92)
	public void risk_Assessment_Agent() throws InterruptedException 
	{
		agents.checkRiskAssessment();
		Thread.sleep(5000);
	}
	
	
	
}
