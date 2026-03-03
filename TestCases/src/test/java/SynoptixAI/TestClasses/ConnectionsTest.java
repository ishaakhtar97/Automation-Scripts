package SynoptixAI.TestClasses;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.Connections;
import SynoptixAI.Pages.DeveloperAgents;
import SynoptixAI.Setup.BaseSetup;

public class ConnectionsTest extends BaseSetup{
	Connections conn;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		conn = new Connections(driver);    // Use global driver from BaseSetup

	}
	
	
	@Test (priority=40)
	public void connectSharePoint() throws InterruptedException 
	{
		conn.navigateToConnScreen();
		conn.connectMSApp("SharePoint");
		Thread.sleep(2000);
	}
	
	@Test (priority=41)
	public void connectTeams() throws InterruptedException 
	{
		conn.navigateToConnScreen();
		conn.connectMSApp("MS Teams");
		Thread.sleep(2000);
	}
	
	@Test (priority=42)
	public void connectOutlook() throws InterruptedException 
	{
		conn.navigateToConnScreen();
		conn.connectMSApp("Outlook");
		Thread.sleep(2000);
	}
	

}