package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.GraphGeneration;
import SynoptixAI.Pages.PresentationBuilder;
import SynoptixAI.Setup.BaseSetup;

public class PresentationBuilderTest  extends BaseSetup{
	PresentationBuilder ppt;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpGraph() {
		ppt = new PresentationBuilder(driver);    
		ppt.turnOnPPTTool();
	}


	@Test (priority=6)
	public void generatePresentation() throws InterruptedException 
	{
		ppt.generatePPT();
		Thread.sleep(2000);
	}
}
