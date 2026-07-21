package SynoptixAI.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import SynoptixAI.Setup.ToolsBaseSetup;

public class WebSearchTool extends ToolsBaseSetup {

	WebDriver driver;
	WebDriverWait wait;
	

	public WebSearchTool(WebDriver driver) 
	{
		super(driver);

	}

	public void  checkWebSearchTool() throws InterruptedException
	{
		String prompt="Find me today Dawn news";
		//newChatWindow();
		turnOnTool("Web Search");
		callTool("Web Search",prompt);
	}
}
