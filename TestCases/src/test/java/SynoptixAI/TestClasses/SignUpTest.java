package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.SignUp;
import SynoptixAI.Setup.BaseSetup;

public class SignUpTest extends BaseSetup {
	SignUp loginForm;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		loginForm = new SignUp(driver);    // Use global driver from BaseSetup

	}

	@Test (priority=0)
	public void createNewAccount() throws InterruptedException 
	{
		loginForm.createAccount();
		Thread.sleep(2000);
	}

	@Test (priority=1)
	public void forgetPassword() throws InterruptedException
	{
		loginForm.forgetPasswd();
		Thread.sleep(2000);
	}
}
