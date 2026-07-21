package SynoptixAI.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import SynoptixAI.Setup.ToolsBaseSetup;

public class MCPs extends ToolsBaseSetup 
{
	WebDriver driver;
	WebDriverWait wait;
	

	public MCPs(WebDriver driver) 
	{
		super(driver);

	}

	public void  checkSharePointMCP() throws InterruptedException
	{
		String prompt=" Explain synoptix AI terms and conditions from files existing on my sharepoint";
		newChatWindow();
		turnOnMCP("SharePoint");
		callTool("SharePoint",prompt);
	}
	public void  checkTeamsMCP() throws InterruptedException
	{
		String prompt="List all the chat group I am the member on teams along with other participants list";
		newChatWindow();
		turnOnMCP("MS Teams");
		callTool("Teams",prompt);
	}
	
	public void  checkOutlookMCP() throws InterruptedException
	{
		String prompt="Show me all folders existing  in my Outlook";
		newChatWindow();
		turnOnMCP("Outlook");
		callTool("Outlook",prompt);
	}
	
	
	
	
}
