package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DataRepo {
	
	WebDriver driver;
	WebDriverWait wait;
	private By DatRepoScreen=By.xpath("//span[normalize-space()='Data Repository']");
	private By dataRepo=By.xpath("//button[normalize-space()='Create First Data Repository' or normalize-space()='Create New Repository']");
	private By dataRepoName=By.xpath("//input[@placeholder='Enter name of new Repository']");
	private By createBtn=By.xpath("//button[normalize-space()='Create']");
	//private By newlyCreatedRepo=By.xpath("//div[@role='row']//div[@col-id='name'][normalize-space()='QA Test Repository']");
	private By newlyCreatedRepo=By.xpath("//span[normalize-space()='QA Test Repository']");
	private By uploadDocBtn=By.xpath("//button[normalize-space()='Upload Document']");
	private By uploadDocFromDevice=By.xpath("//span[normalize-space()='Upload from this device']");
	private By backBtn=By.xpath("//div[@class='flex items-center gap-3']//*[name()='svg']");
	private By optionsBtn=By.xpath("//div[@role='row'][.//div[@col-id='name']//span[normalize-space()='QA Test Repository']]//button[@title='More']");
	private By deleteOption=By.xpath("(//div[@role='menuitem'])[1]");
	private By deleteBtn=By.xpath("//button[normalize-space()='Delete']");
	
	
	public DataRepo(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void createRepo() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(DatRepoScreen)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(dataRepo)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(dataRepoName)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(dataRepoName)).sendKeys("QA Test Repository");
		 wait.until(ExpectedConditions.elementToBeClickable(createBtn)).click();
		 
	}
	public void openRepoFolder() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(newlyCreatedRepo)).click();
		 
	}
	
	public void uploadFile(String filepath) 
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(uploadDocBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(uploadDocBtn)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(uploadDocFromDevice)).click();
		// Step 2: Locate input type=file
        WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@type='file']")
                ));

        // Step 3: Upload ONE file
        fileInput.sendKeys(filepath);
        WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'Successfully') or contains(text(),'processed successfully')]")));
				Assert.assertTrue(successToast.isDisplayed(),"File uploading failed");
		
	}
	public void deleteRepository() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(optionsBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteOption)).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'Successfully') or contains(text(),'deleted successfully')]")));
				Assert.assertTrue(successToast.isDisplayed(),"Repo Deletion failed");
	}
	
	
	
	
	
	
}
