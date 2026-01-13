package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.MyAgents;
import SynoptixAI.Pages.PromptLibrary;
import SynoptixAI.Setup.BaseSetup;

public class PromptLibraryTest extends BaseSetup{
	PromptLibrary prompts;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
	   prompts = new PromptLibrary(driver);    // Use global driver from BaseSetup
 
    }
   @Test (priority=5)
   public void createPrompt() throws InterruptedException 
	{
	   prompts.promptCreation();
		Thread.sleep(2000);
	}
   @Test (priority=6)
   public void editPrompt() throws InterruptedException 
	{
	   prompts.promptUpdation();
		Thread.sleep(2000);
	}
   @Test (priority=7)
   public void deletePrompt() throws InterruptedException 
	{
	   prompts.promptDeletion();
		Thread.sleep(2000);
	}
}
