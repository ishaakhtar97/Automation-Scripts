package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.Users;
import SynoptixAI.Setup.BaseSetup;

public class UserTest extends BaseSetup{
	Users users;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
	   users = new Users(driver);    // Use global driver from BaseSetup
 
    }
        
	@Test (priority=20)
    public void addUser() throws InterruptedException 
	{
		users.addUserFunc();
		Thread.sleep(5000);
	}
	@Test (priority=21)
    public void addGuest() throws InterruptedException 
	{
		users.addGuestFunc();
		Thread.sleep(5000);
	}
}
