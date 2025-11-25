package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.Evaluations;
import SynoptixAI.Pages.MarketingAgents;
import SynoptixAI.Setup.BaseSetup;

public class MarketingAgentsTest extends BaseSetup{

	MarketingAgents agents;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		agents = new MarketingAgents(driver);    // Use global driver from BaseSetup

	}
	@Test (priority=30)
	public void create_BOM_Agent() throws InterruptedException 
	{
		agents.checkCreateBOM();
		Thread.sleep(5000);
	}

	@Test (priority=31)
	public void streamline_Market_Research_And_Stragtegy_Agent() throws InterruptedException 
	{
		agents.checkStreamline();
		Thread.sleep(5000);
	}

	@Test (priority=32)
	public void blog_Generator_Agent() throws InterruptedException 
	{
		agents.checkBlogGenerator();
		Thread.sleep(5000);
	}
	@Test (priority=33)
	public void email_Marketing_Agent() throws InterruptedException 
	{
		agents.checkEmail();
		Thread.sleep(5000);
	}

}
