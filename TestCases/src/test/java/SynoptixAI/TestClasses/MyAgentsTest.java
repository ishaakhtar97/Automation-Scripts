package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.MyAgents;
import SynoptixAI.Pages.Outlook;
import SynoptixAI.Setup.BaseSetup;

public class MyAgentsTest extends BaseSetup{
	MyAgents agents;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
    	agents = new MyAgents(driver);    // Use global driver from BaseSetup
 
    }
	
        
	@Test (priority=10)
    public void createAgent() throws InterruptedException 
	{
		agents.agentCreation();
		Thread.sleep(2000);
	}
	
	@Test (priority=11)
    public void editAgent() throws InterruptedException 
	{
		agents.agentUpdate();
		Thread.sleep(2000);
	}
	
	@Test (priority=12)
	public void deleteAgent() throws InterruptedException 
	{
		agents.agentDelete();
		Thread.sleep(2000);
	}
	
	@Test (priority=13)
	public void shareAgent() throws InterruptedException 
	{
		agents.agentShare();
		Thread.sleep(2000);
	}
}
