package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.AgentLibrary;
import SynoptixAI.Pages.Search;
import SynoptixAI.Setup.BaseSetup;

public class SearchTest extends BaseSetup{
	Search search;	

    // 🔹 Initialize once before any test runs
   @BeforeClass(alwaysRun = true)
    public void setUpObject() {
	   search = new Search(driver);    // Use global driver from BaseSetup
    }
  
   
   @Test (priority=41)
	public void docsFileUpload() throws InterruptedException 
	{
	   search.goToFileWindow();
	   search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Project Status Report.docx");
		Thread.sleep(5000);
	}
	
	@Test (priority=42)
	public void pdfFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Compliance Gap Analysis.pdf");
		Thread.sleep(5000);
	}
	
	@Test (priority=43)
	public void pngFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Trend analysis.PNG");
		Thread.sleep(5000);
	}
	
	@Test (priority=44)
	public void jpgFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Upload test.jpg");
		Thread.sleep(5000);
	}
	
	@Test (priority=45)
	public void xlsxFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\DatabaseName.xlsx");
		Thread.sleep(5000);
	}
	
	@Test (priority=46)
	public void csvFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\customers-1000.csv");
		Thread.sleep(5000);
	}
	
	@Test (priority=47)
	public void pptFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Upload powerpoint.ppt");
		Thread.sleep(5000);
	}
	
	@Test (priority=48)
	public void txtFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\text file.txt");
		Thread.sleep(5000);
	}
	
	@Test (priority=49)
	public void htmlFileUpload() throws InterruptedException 
	{
		search.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\sample2.html");
		Thread.sleep(5000);
	}
	 @Test (priority=52)
  	public void editHistory() throws InterruptedException 
  	{
  	   search.goToFileWindow();
  	   search.editHistory();
  		Thread.sleep(5000);
  	}
   @Test (priority=53)
 	public void deleteHistory() throws InterruptedException 
 	{
 	   search.goToFileWindow();
 	   search.deleteHistory();
 		Thread.sleep(5000);
 	}

}
