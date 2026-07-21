package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SynoptixAI.Setup.ToolsBaseSetup;

public class Tools extends ToolsBaseSetup{

	WebDriver driver;
	WebDriverWait wait;
	

	public Tools(WebDriver driver) 
	{
		super(driver);

	}

	public void  checkGraphGenerationTool() throws InterruptedException
	{
		String prompt="Using dummy data, generate multiple chart types (line, multi-line, bar, multi-bar, pie, doughnut, radar)"
				+ " with proper labels, legends, responsive layout, tooltips, edge-case handling, and clear visual distinction";
		newChatWindow();
		turnOnTool("Interactive Graphs");
		callTool("Interactive Graphs",prompt);
	}
	
	public void  checkImageGenerationTool() throws InterruptedException
	{
		String prompt="Generate me an Image of Dolphin";
		newChatWindow();
		turnOnTool("Image Generator");
		callTool("Image Generator",prompt);
	}

	public void  checkPresentationTool() throws InterruptedException
	{
		String prompt="Generate a 5 slide presentation on Covid-19";
		newChatWindow();
		turnOnTool("Presentation Builder");
		callTool("Presentation Builder",prompt);
	}
	
	public void  checkDashboardTool() throws InterruptedException
	{
		String prompt="Design a dashboard section for bar, line, and pie charts using HTML/CSS placeholders";
		newChatWindow();
		turnOnTool("Dashboard Generator");
		callTool("Dashboard Generator",prompt);
	}
	
	public void  checkLinkedInTool() throws InterruptedException
	{
		String prompt="Create me a linked in post on AI";
		newChatWindow();
		turnOnTool("LinkedIn Post Creator");
		callTool("linkedin",prompt);
	}
	
	public void  checkXPostTool() throws InterruptedException
	{
		String prompt="Create me a X post  on AI";
		newChatWindow();
		turnOnTool("X Post Creator");
		callTool("X",prompt);
	}
	
	public void  checkCodeGeneratorTool() throws InterruptedException
	{
		String prompt="Write a java function to calculate loan EMI and print a summary table with interest"
				+"and principal splits over the repayment schedule.";
		newChatWindow();
		turnOnTool("Code Generator");
		callTool("Code Generator",prompt);
	}
	
	public void  checkWebSearchTool() throws InterruptedException
	{
		String prompt="Find me today Dawn news";
		newChatWindow();
		turnOnTool("Web Search");
		callTool("Web Search",prompt);
	}
	
	
}

