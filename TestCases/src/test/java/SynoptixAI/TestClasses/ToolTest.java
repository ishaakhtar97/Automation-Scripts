package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import SynoptixAI.Pages.Tools;
import SynoptixAI.Setup.BaseSetup;


public class ToolTest extends BaseSetup{
	Tools tool;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpGraph() {
		tool = new Tools(driver);    
		
	}


	@Test (priority=1)
	public void generateGraph() throws InterruptedException 
	{
		tool.checkGraphGenerationTool();
		Thread.sleep(3000);
	}

	@Test (priority=2)
	public void createImage() throws InterruptedException 
	{
		tool.checkImageGenerationTool();
		Thread.sleep(3000);
	}
	
	@Test (priority=3)
	public void generatePresentation() throws InterruptedException 
	{
		tool.checkPresentationTool();
		Thread.sleep(3000);
	}
	
	@Test (priority=4)
	public void generateDashboard() throws InterruptedException 
	{
		tool.checkDashboardTool();
		Thread.sleep(3000);
	}
	
	@Test (priority=5)
	public void searchOnWeb() throws InterruptedException 
	{
		tool.checkWebSearchTool();
		Thread.sleep(3000);
	}
	@Test (priority=6)
	public void generatePythonCode() throws InterruptedException 
	{
		tool.checkCodeGeneratorTool();
		Thread.sleep(3000);
	}
	
	@Test (priority=7)
	public void createLinedInPost() throws InterruptedException 
	{
		tool.checkLinkedInTool();
		Thread.sleep(3000);
	}
	@Test (priority=8)
	public void createXPost() throws InterruptedException 
	{
		tool.checkXPostTool();
		Thread.sleep(3000);
	}
	
}




