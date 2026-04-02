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
	public void docsFileUpload() throws InterruptedException 
	{
		repo.openRepoFolder();
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Project Status Report.docx");
		Thread.sleep(5000);
	}
	
	@Test (priority=42)
	public void pdfFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Compliance Gap Analysis.pdf");
		Thread.sleep(5000);
	}
	
	@Test (priority=43)
	public void pngFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Trend analysis.PNG");
		Thread.sleep(5000);
	}
	
	@Test (priority=44)
	public void jpgFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Upload test.jpg");
		Thread.sleep(5000);
	}
	
	@Test (priority=45)
	public void xlsxFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\DatabaseName.xlsx");
		Thread.sleep(5000);
	}
	
	@Test (priority=46)
	public void csvFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\customers-1000.csv");
		Thread.sleep(5000);
	}
	
	@Test (priority=47)
	public void pptFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\Upload powerpoint.ppt");
		Thread.sleep(5000);
	}
	
	@Test (priority=48)
	public void txtFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\text file.txt");
		Thread.sleep(5000);
	}
	
	@Test (priority=49)
	public void htmlFileUpload() throws InterruptedException 
	{
		repo.uploadFile("C:\\Users\\IshaAkhtar\\Downloads\\sample2.html");
		Thread.sleep(5000);
	}
	
	@Test (priority=50)
	public void deleteRepo() throws InterruptedException 
	{
		repo.deleteRepository();
		Thread.sleep(5000);
	}
	
}
