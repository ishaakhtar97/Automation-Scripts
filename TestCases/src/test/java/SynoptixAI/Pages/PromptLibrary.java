package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PromptLibrary {

	WebDriver driver;
	WebDriverWait wait;

	private By promptLib=By.xpath("//button[.//div[normalize-space()='Prompt Library']]");
	private By myPrompts=By.xpath("//button[normalize-space()='My Prompts']");
	private By createPromptBtn=By.xpath("//button[normalize-space()='Create New Prompt' or normalize-space()='Create Prompt']");
	private By promptName=By.xpath("//input[@placeholder='Enter Prompt Name']");
	private By conField=By.xpath("//div[@class='text-xs text-gray-400']");
	private By addBtn=By.xpath("//button[normalize-space()='Add (1)']");
	private By addBtnUpdate=By.xpath("//button[normalize-space()='Add (2)']");
	private By toolsField=By.xpath("//button[normalize-space()='Tools']");
	private By pptTool=By.cssSelector("p[title='Design professional slides.']");
	private By imageTool=By.cssSelector("//p[@title='Generate images from text prompts.']");
	private By info=By.xpath("//textarea[@placeholder='Enter detailed instructions to get the best results']");
	private By createPrompt=By.xpath("(//button[normalize-space()='Create New Prompt'])");
	private By updatePrompt=By.xpath("(//button[normalize-space()='Update'])");
	private By optionsBtn=By.xpath("(//button[.//*[name()='svg']])[4]");
	private By editBtn=By.xpath("//div[contains(text(),'Edit')]");
	private By deleteOpt=By.xpath("//div[contains(text(),'Delete')]");
	private By deleteBtn=By.xpath("//button[normalize-space()='Delete']");
	private By editTools=By.xpath("(//img[@alt='Presentation Builder'])[4]");	
	private By copyBtn=By.xpath("//div[contains(text(),'Copy')]");
	
	
	public PromptLibrary(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}



	public void promptCreation() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(promptLib)).click();
		wait.until(ExpectedConditions.elementToBeClickable(myPrompts)).click();
		wait.until(ExpectedConditions.elementToBeClickable(createPromptBtn)).click();
		WebElement namefield=wait.until(ExpectedConditions.elementToBeClickable(promptName));
		namefield.click();
		namefield.sendKeys("General Prompt");
		wait.until(ExpectedConditions.elementToBeClickable(conField)).click();
		WebElement tools = wait.until(ExpectedConditions.elementToBeClickable(toolsField));
		tools.click();
		Thread.sleep(1000);
		WebElement slidesTool = wait.until(ExpectedConditions.elementToBeClickable(pptTool));
		slidesTool.click();
		WebElement addTool = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		addTool.click();
		WebElement prompt = wait.until(ExpectedConditions.elementToBeClickable(info));
		prompt.click();
		prompt.sendKeys("Who is the current CM of Punjab, Pakistan?");
		wait.until(ExpectedConditions.elementToBeClickable(createPrompt)).click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'created')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Prompt creation failed");
		System.out.println(successToast.getText());

		
	}
	
	public void promptUpdation() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(optionsBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		/*WebElement namefield=wait.until(ExpectedConditions.elementToBeClickable(promptName));
		namefield.click();
		namefield.sendKeys("General Prompt for image");
		wait.until(ExpectedConditions.elementToBeClickable(editTools)).click();
		WebElement tools = wait.until(ExpectedConditions.elementToBeClickable(toolsField));
		tools.click();
		Thread.sleep(1000);
		WebElement slidesTool = wait.until(ExpectedConditions.elementToBeClickable(imageTool));
		slidesTool.click();
		WebElement addTool = wait.until(ExpectedConditions.elementToBeClickable(addBtnUpdate));
		addTool.click();*/
		WebElement prompt = wait.until(ExpectedConditions.elementToBeClickable(info));
		prompt.click();
		prompt.sendKeys("Who is the current CM of Punjab, Pakistan?");
		wait.until(ExpectedConditions.elementToBeClickable(updatePrompt)).click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'Updated')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Prompt updation failed");
		System.out.println(successToast.getText());

	}
	public void promptDeletion() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(optionsBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteOpt)).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'Deleted')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Prompt deletion failed");
		System.out.println(successToast.getText());

	}
	




}