package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.FinanceAgents;
import SynoptixAI.Pages.ProjectManagementAgents;
import SynoptixAI.Setup.BaseSetup;

public class FinanceAgentsTest extends BaseSetup{
	
	FinanceAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new FinanceAgents(driver);    // Use global driver from BaseSetup

	}
	
	@Test (priority=1)
	public void accounting_Document_Evalution_Agent() throws InterruptedException 
	{
		agents.checkAccountingDoc();
		Thread.sleep(5000);
	}
	@Test (priority=2)
	public void finance_EOM_Accruals_Agent() throws InterruptedException 
	{
		agents.checkEOMAccruals();
		Thread.sleep(5000);
	}

	@Test (priority=121)
	public void finance_Management_GuideBook_Agent() throws InterruptedException 
	{
		agents.checkFinanceManagement();
		Thread.sleep(5000);
	}
	
	@Test (priority=125)
	public void financial_Anamoly_Detector_Agent() throws InterruptedException 
	{
		agents.checkAnamolyDetectorAgent();
		Thread.sleep(5000);
	}
	
}
