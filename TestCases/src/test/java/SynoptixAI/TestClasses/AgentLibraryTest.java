package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.AgentLibrary;
import SynoptixAI.Pages.MyAgents;
import SynoptixAI.Setup.BaseSetup;

public class AgentLibraryTest extends BaseSetup{
	AgentLibrary library;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
	   library = new AgentLibrary(driver);    // Use global driver from BaseSetup
    }
   
   @Test (priority=15)
   public void deployAgent() throws InterruptedException 
	{
	   library.agentDeploy();
		Thread.sleep(2000);
	}
}