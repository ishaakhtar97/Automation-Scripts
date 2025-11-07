package SynoptixAI.TestClasses;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.Outlook;
import SynoptixAI.Setup.BaseSetup;
import SynoptixAI.TestClasses.LoginTest;



public class OutlookTest extends BaseSetup{
	Outlook outlook;	

    // 🔹 Initialize once before any test runs
    @BeforeClass(alwaysRun = true)
    public void setUpOutlook() {
        outlook = new Outlook(driver);    // Use global driver from BaseSetup
        outlook.turnOnOutlookCon();       // Turn on Outlook connection once
    }
	
        
	@Test (priority=1, dependsOnGroups = "login", groups="Outlook")
    public void generateMeetingLink() throws InterruptedException 
	{
		outlook.generateMeetingLink();
		Thread.sleep(2000);
	}
	
	@Test (priority=2, dependsOnGroups = "login", groups="Outlook")
	public void draftNewEmail() throws InterruptedException
	{
	outlook.draftEmail();
	Thread.sleep(2000);
	}
	
}
