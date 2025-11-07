package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SynoptixAI.Pages.xPost;
import SynoptixAI.Setup.BaseSetup;

public class xPostTest extends BaseSetup{
	xPost post;

// 🔹 Initialize once before any test runs
@BeforeClass(alwaysRun = true)
public void setUpX() {
	post = new xPost(driver);    
	post.turnOnXTool();
}

    
@Test (priority=5)
public void createXPost() throws InterruptedException 
{
	post.createPost();
	Thread.sleep(2000);
}

}
