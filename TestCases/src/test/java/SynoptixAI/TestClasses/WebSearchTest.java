package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.PresentationBuilder;
import SynoptixAI.Pages.WebSearchTool;
import SynoptixAI.Setup.BaseSetup;

public class WebSearchTest extends BaseSetup{
	WebSearchTool webSearch;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpGraph() {
		webSearch = new WebSearchTool(driver);    
		
	}


	@Test (priority=6)
	public void searchOnWeb() throws InterruptedException 
	{
		webSearch.checkWebSearchTool();
		Thread.sleep(2000);
	}

}
