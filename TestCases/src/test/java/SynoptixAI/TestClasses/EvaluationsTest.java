package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.Evaluations;
import SynoptixAI.Pages.Users;
import SynoptixAI.Setup.BaseSetup;

public class EvaluationsTest extends BaseSetup {
	Evaluations eval;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
	   eval = new Evaluations(driver);    // Use global driver from BaseSetup

    }
        
	@Test (priority=30)
    public void checkLatency() throws InterruptedException 
	{
		eval.checkLatencyGraph();
		Thread.sleep(5000);
	}

	
}
