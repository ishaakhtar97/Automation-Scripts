package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.DataRepo;
import SynoptixAI.Pages.ProfileMenu;
import SynoptixAI.Setup.BaseSetup;

public class ProfileMenuTest extends BaseSetup{
	ProfileMenu menu;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		menu = new ProfileMenu(driver);    // Use global driver from BaseSetup

	}
	
	@Test (priority=40)
	public void reportABug() throws InterruptedException 
	{
		menu.reportBug("C:\\Users\\IshaAkhtar\\Downloads\\Trend analysis.PNG");
		Thread.sleep(2000);
	}
	
	@Test (priority=41)
	public void giveAIinstructions() throws InterruptedException 
	{
		menu.aiInsctructions();
		Thread.sleep(2000);
	}
	

}
