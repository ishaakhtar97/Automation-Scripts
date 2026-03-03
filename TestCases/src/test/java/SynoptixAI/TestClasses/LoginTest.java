package SynoptixAI.TestClasses;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.AuthenticationPage;
import SynoptixAI.Pages.DataRepo;
import SynoptixAI.Pages.SimpleLogin;
import SynoptixAI.Pages.LoginOptionsPage;
import SynoptixAI.Pages.MSLogin;
import SynoptixAI.Pages.StaySignedInPage;
import SynoptixAI.Setup.BaseSetup;

public class LoginTest extends BaseSetup{

	SimpleLogin loginForm;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		loginForm = new SimpleLogin(driver);    // Use global driver from BaseSetup

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

	@Test (priority=2)
	public void successfulLogin() throws InterruptedException {

		// Step 1: Email

		loginForm.enterEmail("isha.akhtar@synoptix.ai");
		loginForm.enterPassword("Ish@nauman97");
		loginForm.Login();
		Thread.sleep(9000);
	}


	/*  // Step 2: Password
        PasswordPage passwordPage = new PasswordPage(driver);
       passwordPage.enterPassword("Ish@nauman97");
        passwordPage.clickSignIn();*/

	/* // Wait for Authenticator approval to complete
        AuthenticationPage authPage = new AuthenticationPage(driver);
        authPage.waitForYes();

        StaySignedInPage stayPage = new StaySignedInPage(driver);
        // Handle Stay Signed In page
        try {

            stayPage.clickYes();
         // Wait for final redirect to your app’s home page

        } catch (Exception e) {
            System.out.println("Stay signed in page not shown this time — continuing...");
        }

    stayPage.waitForLoginCompletion();
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='85%'");


        System.out.println("Microsoft Login flow completed");
    }
	 */
}
