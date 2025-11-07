package SynoptixAI.TestClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import SynoptixAI.Pages.AuthenticationPage;
import SynoptixAI.Pages.EmailPage;
import SynoptixAI.Pages.PasswordPage;
import SynoptixAI.Pages.StaySignedInPage;
import SynoptixAI.Setup.BaseSetup;

public class LoginTest extends BaseSetup{
	
	
	@Test (groups="login")
    public void testValidLogin() {
		// Step 1: Email
        EmailPage emailPage = new EmailPage(driver);
        emailPage.enterEmail("isha.akhtar@synoptix.ai");
        emailPage.clickNext();

        // Step 2: Password
        PasswordPage passwordPage = new PasswordPage(driver);
       passwordPage.enterPassword("Mow078256");
        passwordPage.clickSignIn();
        
        // Wait for Authenticator approval to complete
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

}
