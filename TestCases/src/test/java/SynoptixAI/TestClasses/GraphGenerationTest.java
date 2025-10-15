package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.GraphGeneration;
import SynoptixAI.Pages.Outlook;
import SynoptixAI.Setup.BaseSetup;
import SynoptixAI.TestClasses.OutlookTest;

public class GraphGenerationTest extends BaseSetup{
	GraphGeneration chart;

    // 🔹 Initialize once before any test runs
    @BeforeClass(alwaysRun = true)
    public void setUpGraph() {
    	chart = new GraphGeneration(driver);    
    	
    }
	
        
	@Test (priority=3, dependsOnGroups = "Outlook")
    public void generateBarGraph() throws InterruptedException 
	{
		chart.generateGraph();
	}
	
	
	

}
