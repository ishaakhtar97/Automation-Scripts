package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.AgentLibrary;
import SynoptixAI.Pages.MyAgents;
import SynoptixAI.Setup.BaseSetup;

public class AgentLibraryTest extends BaseSetup{
	AgentLibrary library;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
	   library = new AgentLibrary(driver);    // Use global driver from BaseSetup
    }
   
   @Test (priority=15)
   public void deployAgent() throws InterruptedException 
	{
	   library.agentDeploy();
		Thread.sleep(2000);
	}
   
   @Test (priority=41)
	public void docsFileUpload() throws InterruptedException 
	{
	   library.goToAgentWindow();
	   library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Project Status Report.docx");
		Thread.sleep(5000);
	}
	
	@Test (priority=42)
	public void pdfFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Compliance Gap Analysis.pdf");
		Thread.sleep(5000);
	}
	
	@Test (priority=43)
	public void pngFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Trend analysis.PNG");
		Thread.sleep(5000);
	}
	
	@Test (priority=44)
	public void jpgFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Upload test.jpg");
		Thread.sleep(5000);
	}
	
	@Test (priority=45)
	public void xlsxFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\DatabaseName.xlsx");
		Thread.sleep(5000);
	}
	
	@Test (priority=46)
	public void csvFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\customers-1000.csv");
		Thread.sleep(5000);
	}
	
	@Test (priority=47)
	public void pptFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Upload powerpoint.ppt");
		Thread.sleep(5000);
	}
	
	@Test (priority=48)
	public void txtFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\text file.txt");
		Thread.sleep(5000);
	}
	
	@Test (priority=49)
	public void htmlFileUpload() throws InterruptedException 
	{
		library.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\sample2.html");
		Thread.sleep(5000);
	}
	
}