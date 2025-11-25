package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.ResearcherAgents;
import SynoptixAI.Setup.BaseSetup;

public class ResearcherAgentsTest extends BaseSetup{
	
	ResearcherAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new ResearcherAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=50)
	public void trends_Analyst_Agent() throws InterruptedException 
	{
		agents.checkTrendsAnalyst();
		Thread.sleep(5000);
	}

	@Test (priority=51)
	public void market_Competitors_Analysis_Agent() throws InterruptedException 
	{
		agents.checkMarketCompetitor();
		Thread.sleep(5000);
	}

}
