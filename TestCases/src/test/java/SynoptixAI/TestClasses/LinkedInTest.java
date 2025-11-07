package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.LinkedIn;
import SynoptixAI.Setup.BaseSetup;

public class LinkedInTest extends BaseSetup{
	LinkedIn post;

// 🔹 Initialize once before any test runs
@BeforeClass(alwaysRun = true)
public void setUpLinkedIn() {
	post = new LinkedIn(driver);    
	post.turnOnLinkedInTool();
}

    
@Test (priority=4)
public void createLinkedInPost() throws InterruptedException 
{
	post.createPost();
	Thread.sleep(2000);
}

}
