package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAgents {

	WebDriver driver;
	WebDriverWait wait;

	private By myAgents=By.xpath("//span[normalize-space()='My Agents']");
	private By createAgent=By.xpath("//a[normalize-space()='Create Agent']");
	private By nameField=By.xpath("//input[@placeholder='New Agent']");
	private By descField=By.cssSelector("input[placeholder='Add a one line description']");
	private By modelField=By.xpath("//div[@class='flex items-start gap-2']");
	private By selectModel=By.xpath("//div[@id='radix-_r_m_']");
	private By conField=By.xpath("//span[normalize-space()='Select Connections & Tools']");
	private By sharePointCon=By.cssSelector("p[title='Search, read, and update your company documents.']");
	private By addBtn=By.xpath("//button[normalize-space()='Add (1)']");
	private By toolsField=By.xpath("//button[normalize-space()='Tools']");
	private By pptTool=By.cssSelector("p[title='Design professional slides.']");
	private By info=By.cssSelector("textarea[placeholder='You are AI assistant that helps people find information']");
	private By deployBtn=By.xpath("	//button[normalize-space()='Deploy']");
	private By options=By.xpath("(//button[.//*[name()='svg']])[5]");
	private By share=By.xpath("//div[normalize-space()='Share']");
	private By edit=By.xpath("//div[normalize-space()='Edit']");
	private By delete=By.xpath("//div[normalize-space()='Edit']/following-sibling::div[2]");
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
		/*WebElement model = wait.until(ExpectedConditions.elementToBeClickable(modelField));
		model.click();
		WebElement chooseModel = wait.until(ExpectedConditions.elementToBeClickable(selectModel));
		chooseModel.click();*/
		WebElement connections = wait.until(ExpectedConditions.elementToBeClickable(conField));
		connections.click();
		Thread.sleep(1000);
		WebElement selectCon = wait.until(ExpectedConditions.elementToBeClickable(sharePointCon));
		selectCon.click();
		//WebElement add = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		//add.click();
		Thread.sleep(1000);
		WebElement tools = wait.until(ExpectedConditions.elementToBeClickable(toolsField));
		tools.click();
		Thread.sleep(1000);
		WebElement slidesTool = wait.until(ExpectedConditions.elementToBeClickable(pptTool));
		slidesTool.click();
		WebElement addTool = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		addTool.click();
		WebElement agentInfo = wait.until(ExpectedConditions.elementToBeClickable(info));
		agentInfo.click();
		agentInfo.sendKeys("PMO Agent is typically designed to assist with managing and streamlining project management tasks within an organization.");
		WebElement deployAgent = wait.until(ExpectedConditions.elementToBeClickable(deployBtn));
		deployAgent.click();
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'deployed')]")
					));

			System.out.println("Agent created " + successToast.getText());

		} catch (Exception e) {
			System.out.println("Agent may not get created");
		}

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
		WebElement url = wait.until(ExpectedConditions.elementToBeClickable(urlField));
		url.click();
		url.sendKeys("https://www.google.com/");
		Thread.sleep(2000);
		WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(update));
		updateBtn.click();
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'successfully') or contains(text(),'Updated Sucessfully')]")
					));

			System.out.println("Agent updated " + successToast.getText());

		} catch (Exception e) {
			System.out.println("Agent may not get updated");
		}
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
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'Successfully') or contains(text(),'Deleted Successfully')]")
					));

			System.out.println("Agent Deleted " + successToast.getText());

		} catch (Exception e) {
			System.out.println("Agent may not get updated");
		}
	}

}
