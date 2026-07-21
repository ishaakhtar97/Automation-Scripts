package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.MCPs;
import SynoptixAI.Setup.BaseSetup;

public class MCPsTest extends BaseSetup{
	MCPs mcp;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpGraph() {
		mcp = new MCPs(driver);    
		
	}

	@Test (priority=1)
	public void sharePointMCP() throws InterruptedException 
	{
		mcp.checkSharePointMCP();
		Thread.sleep(3000);
	}
	
	/*@Test (priority=2)
	public void teamsMCP() throws InterruptedException 
	{
		mcp.checkTeamsMCP();
		Thread.sleep(3000);
	}
	@Test (priority=3)
	public void outlookMCP() throws InterruptedException 
	{
		mcp.checkOutlookMCP();
		Thread.sleep(3000);
	}
*/
}
