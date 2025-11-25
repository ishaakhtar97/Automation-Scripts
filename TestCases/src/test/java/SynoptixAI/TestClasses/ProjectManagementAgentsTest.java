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
	@Test (priority=90)
	public void generate_Task_Plans_Agent() throws InterruptedException 
	{
		agents.checkGenerateTask();
		Thread.sleep(5000);
	}

	@Test (priority=91)
	public void resource_Planning_And_Management_Agent() throws InterruptedException 
	{
		agents.checkResourcePlanning();
		Thread.sleep(5000);
	}
	
	@Test (priority=92)
	public void risk_Assessment_Agent() throws InterruptedException 
	{
		agents.checkRiskAssessment();
		Thread.sleep(5000);
	}
	
	@Test (priority=93)
	public void risk_Mitigation_Assistant_Agent() throws InterruptedException 
	{
		agents.checkRiskMitigation();
		Thread.sleep(5000);
	}
	@Test (priority=94)
	public void summarise_Project_Updates_Agent() throws InterruptedException 
	{
		agents.checkSummariseProjectAgent();
		Thread.sleep(5000);
	}
	
}
