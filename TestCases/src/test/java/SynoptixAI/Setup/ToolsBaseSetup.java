package SynoptixAI.Setup;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ToolsBaseSetup {
	WebDriver driver;
	WebDriverWait wait;

	protected By connections=By.xpath("//button[.//img[@alt='Connections']]");
	protected By tools=By.xpath("//div[contains(@class,'fixed')]//button[normalize-space()='Tools']");
	protected By closeCon=By.xpath("//button[.//span[text()='Close']]");
	protected By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	protected By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
	protected By sendBtnLoc=By.cssSelector("img[alt='Send']");
	protected By likeBtnLoc=By.xpath("//button[@title='Like']");
	protected By stopBtnLoc=By.xpath("//button[@title='Stop generating']");

	public ToolsBaseSetup(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	}
	public void newChatWindow() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(newChatBtnLoc)).click();
		Thread.sleep(3000);
	}

	public void turnOnTool(String toolName) throws InterruptedException {
		By toolLocator = By.xpath("//span[contains(@class,'font-medium') and normalize-space()='" + toolName + "']");
		By popup = By.xpath("//div[@role='dialog']");

		WebElement conBtn = wait.until(ExpectedConditions.elementToBeClickable(connections));

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", conBtn);
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(popup));

		WebElement toolsBtn =wait.until(ExpectedConditions.visibilityOfElementLocated(tools));
		Actions act = new Actions(driver);
		act.moveToElement(toolsBtn).pause(Duration.ofMillis(300)).click().perform();
		Thread.sleep(1000);
		WebElement selectTool =wait.until(ExpectedConditions.visibilityOfElementLocated(toolLocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectTool);
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(toolLocator)).click();
		wait.until(ExpectedConditions.elementToBeClickable(closeCon)).click();
		Thread.sleep(1000);
	}
	
	public void turnOnMCP(String toolName) throws InterruptedException {
		By toolLocator = By.xpath("//span[contains(@class,'font-medium') and normalize-space()='" + toolName + "']");
		By popup = By.xpath("//div[@role='dialog']");

		WebElement conBtn = wait.until(ExpectedConditions.elementToBeClickable(connections));

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", conBtn);
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(popup));

		/*WebElement toolsBtn =wait.until(ExpectedConditions.visibilityOfElementLocated(tools));
		Actions act = new Actions(driver);
		act.moveToElement(toolsBtn).pause(Duration.ofMillis(300)).click().perform();*/
		Thread.sleep(1000);
		WebElement selectTool =wait.until(ExpectedConditions.visibilityOfElementLocated(toolLocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectTool);
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(toolLocator)).click();
		wait.until(ExpectedConditions.elementToBeClickable(closeCon)).click();
		Thread.sleep(1000);
	}

	public void callTool(String toolName, String prompt) throws InterruptedException
	{
		By toolTriggered = By.xpath("//span[normalize-space()='" + toolName + "']");

		WebElement promptField =
				wait.until(ExpectedConditions.elementToBeClickable(promptFieldLoc));

		promptField.click();
		promptField.sendKeys(prompt);

		WebElement sendButton =
				wait.until(ExpectedConditions.elementToBeClickable(sendBtnLoc));

		sendButton.click();

		boolean toolDisplayed = false;

		// ================= TOOL TRIGGER VALIDATION =================

		if (!toolName.equals("Dashboard Generator"))
		{
			try
			{
				WebDriverWait toolWait =
						new WebDriverWait(driver, Duration.ofMinutes(2));

				WebElement triggeredTool =
						toolWait.until(ExpectedConditions
								.visibilityOfElementLocated(toolTriggered));

				toolDisplayed = triggeredTool.isDisplayed();

				if (toolDisplayed)
				{
					System.out.println(toolName + " Tool triggered successfully");
				}
			}
			catch (TimeoutException e)
			{
				System.out.println(toolName + " trigger not displayed.");
			}
		}

		// ================= RESPONSE VALIDATION =================

		try
		{
			WebDriverWait responseWait =
					new WebDriverWait(driver, Duration.ofMinutes(3));

			WebElement likeBtn =
					responseWait.until(
							ExpectedConditions.visibilityOfElementLocated(likeBtnLoc));

			Assert.assertTrue(likeBtn.isDisplayed(),
					"Response completed successfully");

			// FAIL TEST if tool was not displayed
			if (!toolDisplayed && !toolName.equals("Dashboard Generator"))
			{
				Assert.fail(toolName +
						" response completed but tool trigger was not displayed");
			}

			System.out.println(toolName + " response completed successfully");
		}
		catch (TimeoutException e)
		{
			System.out.println(
					"Response not received within timeout. Clicking stop button...");

			WebElement stopBtn =
					wait.until(ExpectedConditions
							.elementToBeClickable(stopBtnLoc));

			((JavascriptExecutor) driver)
			.executeScript("arguments[0].click();", stopBtn);

			Assert.fail(
					"Test failed because response was not generated within timeout");
		}
	}
	
	/*  public void callTool(String toolName, String prompt) throws InterruptedException
{
    By toolTriggered =
            By.xpath("//span[normalize-space()='" + toolName + "']");

    WebElement promptField =
            wait.until(ExpectedConditions.elementToBeClickable(promptFieldLoc));

    promptField.click();
    promptField.sendKeys(prompt);

    WebElement sendButton =
            wait.until(ExpectedConditions.elementToBeClickable(sendBtnLoc));

    sendButton.click();

    boolean toolDisplayed = false;
    boolean responseCompleted = false;

    long startTime = System.currentTimeMillis();
    long timeout = Duration.ofMinutes(3).toMillis();

    while (System.currentTimeMillis() - startTime < timeout)
    {
        // CHECK TOOL TRIGGER
        if (!toolDisplayed && !toolName.equals("Dashboard Generator"))
        {
            try
            {
                WebElement tool =
                        driver.findElement(toolTriggered);

                if (tool.isDisplayed())
                {
                    toolDisplayed = true;
                    System.out.println(toolName +
                            " Tool triggered successfully");
                }
            }
            catch (Exception e)
            {
                // Ignore until timeout
            }
        }

        // CHECK LIKE BUTTON
        try
        {
            WebElement likeBtn =
                    driver.findElement(likeBtnLoc);

            if (likeBtn.isDisplayed())
            {
                responseCompleted = true;

                System.out.println(toolName +
                        " response completed successfully");

                break; // EXIT IMMEDIATELY
            }
        }
        catch (Exception e)
        {
            // Ignore until timeout
        }

        Thread.sleep(1000);
    }

    // IF RESPONSE NEVER COMPLETED
    if (!responseCompleted)
    {
        System.out.println(
                "Response not received within timeout. Clicking stop button...");

        try
        {
            WebElement stopBtn =
                    wait.until(ExpectedConditions
                            .elementToBeClickable(stopBtnLoc));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", stopBtn);
        }
        catch (Exception ignored) {}

        Assert.fail(
                "Test failed because response was not generated within timeout");
    }

    // RESPONSE COMPLETED BUT TOOL NEVER TRIGGERED
    if (!toolDisplayed && !toolName.equals("Dashboard Generator"))
    {
        Assert.fail(toolName +
                " response completed but tool trigger was not displayed");
    }
}*/
	


}
