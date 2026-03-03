package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import SynoptixAI.Pages.DataRepo;
import SynoptixAI.Setup.BaseSetup;

public class DataRepoTest extends BaseSetup{
	DataRepo repo;	

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpObject() {
		repo = new DataRepo(driver);    // Use global driver from BaseSetup

	}
	
	@Test (priority=40)
	public void createNewRepo() throws InterruptedException 
	{
		repo.createRepo();
		Thread.sleep(5000);
	}
	

	@Test (priority=41)
	public void uploadDocsFile() throws InterruptedException 
	{
		repo.openRepoFolder();
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Project Status Report.docx");
		Thread.sleep(5000);
	}
	
	
	
	@Test (priority=42)
	public void uploadPdfFile() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Compliance Gap Analysis.pdf");
		Thread.sleep(5000);
	}
	
	@Test (priority=43)
	public void deleteRepo() throws InterruptedException 
	{
		repo.deleteRepository();
		Thread.sleep(5000);
	}
	
}
