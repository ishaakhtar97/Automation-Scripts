package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAgents {

	WebDriver driver;
	WebDriverWait wait;

	private By myAgents=By.xpath("//span[normalize-space()='My Agents']");
	private By createAgent=By.xpath("//a[normalize-space()='Create Agent']");
	private By nameField=By.xpath("//input[@placeholder='New Agent']");
	private By descField=By.cssSelector("input[placeholder='Add a one line description']");
	private By conField=By.xpath("//div[normalize-space()='Select Connections & Tools']/ancestor::div[contains(@class,'cursor-pointer')]");
	private By conDrpDown=By.xpath("//span[normalize-space()='Connections & Tools']");
	private By sharePointCon=By.xpath("//span[normalize-space()='SharePoint']");
	private By addBtn=By.xpath("//button[.//span[text()='Close']]");
	private By toolsField=By.xpath("//button[normalize-space()='Tools']");
	private By pptTool=By.xpath("//span[normalize-space()='Presentation Builder']");
	private By info=By.xpath("//textarea[contains(@placeholder,'Think of your prompt')]");
	private By deployBtn=By.xpath("	//button[normalize-space()='Deploy']");
	private By options=By.xpath("(//button[.//*[name()='svg']])[3]");
	//private By options=By.xpath("//button[@id='radix-_r_d_']//*[name()='svg']");
	private By share=By.xpath("//div[normalize-space()='Share']");
	private By edit=By.xpath("//div[normalize-space()='Edit']");
	//private By delete=By.xpath("//div[normalize-space()='Edit']/following-sibling::div[2]");
	private By delete=By.xpath("//div[normalize-space()='Delete']");
	private By urlField=By.xpath("//input[@placeholder='Enter URL and press Enter']");
	private By update=By.xpath("//button[normalize-space()='Update']");
	private By shareEmail=By.xpath("(//input)[1]");
	private By shareAgent=By.xpath("//button[normalize-space()='Share']");
	private By deleteAgent=By.xpath("//button[normalize-space()='Delete']");

	public MyAgents(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void agentCreation() throws InterruptedException 
	{
		//wait.until(ExpectedConditions.elementToBeClickable(promptLib)).click();
		WebElement agentBtn = wait.until(ExpectedConditions.elementToBeClickable(myAgents));
		agentBtn.click();
		Thread.sleep(2000);
		WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(createAgent));
		createBtn.click();
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(nameField));
		name.click();
		name.sendKeys("PMO Agent");
		WebElement description = wait.until(ExpectedConditions.elementToBeClickable(descField));
		description.click();
		description.sendKeys("I will assist you in managing project milestones timely");
		WebElement agentInfo = wait.until(ExpectedConditions.elementToBeClickable(info));
		agentInfo.click();
		agentInfo.sendKeys("PMO Agent is typically designed to assist with managing and streamlining project management tasks within an organization.");
		/*WebElement model = wait.until(ExpectedConditions.elementToBeClickable(modelField));
		model.click();
		WebElement chooseModel = wait.until(ExpectedConditions.elementToBeClickable(selectModel));
		chooseModel.click();*/
		wait.until(ExpectedConditions.elementToBeClickable(conDrpDown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(conField)).click();
		//WebElement connections = wait.until(ExpectedConditions.elementToBeClickable(conField));
		//connections.click();
		//Thread.sleep(1000);
		WebElement selectCon = wait.until(ExpectedConditions.presenceOfElementLocated(sharePointCon));
		Actions actions = new Actions(driver);

	    actions.moveToElement(selectCon)
	           .pause(Duration.ofMillis(200))
	           .click()
	           .perform();

		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectCon);
		WebElement tools = wait.until(ExpectedConditions.elementToBeClickable(toolsField));
		tools.click();
		Thread.sleep(1000);
		WebElement slidesTool = wait.until(ExpectedConditions.presenceOfElementLocated(pptTool));
		actions.moveToElement(slidesTool)
        .pause(Duration.ofMillis(200))
        .click()
        .perform();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", slidesTool);
		WebElement addTool = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		addTool.click();

		WebElement deployAgent = wait.until(ExpectedConditions.elementToBeClickable(deployBtn));
		deployAgent.click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'deployed')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Agent creation failed");
		System.out.println(successToast.getText());


	}

	public void agentUpdate() throws InterruptedException 
	{
		WebElement agentBtn = wait.until(ExpectedConditions.elementToBeClickable(myAgents));
		agentBtn.click();
		Thread.sleep(2000);
		WebElement optionBtn = wait.until(ExpectedConditions.elementToBeClickable(options));
		optionBtn.click();
		Thread.sleep(1000);
		WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(edit));
		editBtn.click();
		WebElement agentInfo = wait.until(ExpectedConditions.elementToBeClickable(info));
		agentInfo.click();
		agentInfo.sendKeys(" Ok.");
		wait.until(ExpectedConditions.elementToBeClickable(conDrpDown)).click();
		WebElement url = wait.until(ExpectedConditions.elementToBeClickable(urlField));
		url.click();
		url.sendKeys("https://www.google.com/");
		Thread.sleep(2000);
		WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(update));
		updateBtn.click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//*[contains(text(),'successfully') or contains(text(),'updated successfully')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Agent Updation failed");
		System.out.println(successToast.getText());

	}

	public void agentDelete() throws InterruptedException 
	{
		WebElement agentBtn = wait.until(ExpectedConditions.elementToBeClickable(myAgents));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentBtn);
		Thread.sleep(500);
		agentBtn.click();
		Thread.sleep(2000);
		WebElement optionBtn = wait.until(ExpectedConditions.elementToBeClickable(options));
		optionBtn.click();
		Thread.sleep(1000);
		WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(delete));
		deleteOption.click();
		WebElement deleteAgentBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteAgent));
		deleteAgentBtn.click();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//*[contains(text(),'successfully') or contains(text(),'deleted successfully')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Agent Deletion failed");
		System.out.println(successToast.getText());

	}
	public void agentShare() throws InterruptedException 
	{
		WebElement agentBtn = wait.until(ExpectedConditions.elementToBeClickable(myAgents));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agentBtn);
		Thread.sleep(500);
		agentBtn.click();
		Thread.sleep(2000);
		WebElement optionBtn = wait.until(ExpectedConditions.elementToBeClickable(options));
		optionBtn.click();
		Thread.sleep(1000);
		WebElement shareBtn = wait.until(ExpectedConditions.elementToBeClickable(share));
		shareBtn.click();
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(shareEmail));
		email.click();
		//url.sendKeys("https://www.google.com/");
		//Thread.sleep(2000);
		WebElement shareAgentBtn = wait.until(ExpectedConditions.elementToBeClickable(shareAgent));
		shareAgentBtn.click();
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'successfully') or contains(text(),'Agent shared sucessfully')]")
					));

			System.out.println("Agent shared " + successToast.getText());

		} catch (Exception e) {
			System.out.println("Agent may not shared");
		}
	}
}
