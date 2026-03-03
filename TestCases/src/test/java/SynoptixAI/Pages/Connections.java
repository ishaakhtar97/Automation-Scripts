package SynoptixAI.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Connections {
	WebDriver driver;
	WebDriverWait wait;

	private By connScreen=By.xpath("//span[normalize-space()='Connections']");
	private By connectBtn=By.xpath("//div[contains(@class,'bg-gradient')]//button[normalize-space()='Connect']");
	private By myMSAcc=By.xpath("(//div[@data-bind='text: session.tileDisplayName'])[1]");
	private By reconnectBtn=By.xpath("//div[@role='menuitem' and normalize-space()='Reconnect']");


	public Connections(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}

	public void navigateToConnScreen() {
		wait.until(ExpectedConditions.elementToBeClickable(connScreen)).click();

	}


	public void connectMSApp(String appName) throws InterruptedException {

		WebElement appCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h3[normalize-space()='" + appName + "']/ancestor::div[contains(@class,'rounded-lg')]")
				));

		// CONNECTED → do nothing
		if (!appCard.findElements(
				By.xpath(".//span[normalize-space()='connected']")
				).isEmpty()) {
			System.out.println(appName + " already connected");
			return;
		}

		// DISCONNECTED → reconnect
		if (!appCard.findElements(
				By.xpath(".//span[normalize-space()='disconnected']")
				).isEmpty()) {
			System.out.println(appName + " disconnected, reconnecting");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", appCard);
			js.executeScript("arguments[0].click();", appCard); // opens modal
			clickReconnectButton(appName);
			return;
		}

		// NO STATUS → fresh connect
		System.out.println("No status found, connecting " + appName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", appCard);
		js.executeScript("arguments[0].click();", appCard);
		clickConnectButton();
}


	private void clickConnectButton() throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(connectBtn)).click();
		handleMSAccountSelection();

		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'connected')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Connection failed");

	}


	private void clickReconnectButton(String appName) throws InterruptedException {
		// TODO Auto-generated method stub

		WebElement appCard = wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.xpath("//h3[normalize-space()='" + appName + "']/ancestor::div[contains(@class,'rounded-lg')]")));
		
		new Actions(driver).moveToElement(appCard).perform();

		WebElement optionsBtn= wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//h3[normalize-space()='" + appName + "']"+
						"/ancestor::div[contains(@class,'relative')]" +
						"/button[@aria-haspopup='menu']")));
		
		Actions actions = new Actions(driver);

	    actions.moveToElement(optionsBtn)
	           .pause(Duration.ofMillis(200))
	           .click()
	           .perform();

	    WebElement reconnect =wait.until(ExpectedConditions.visibilityOfElementLocated(reconnectBtn));
		
		actions.moveToElement(reconnect)
        .pause(Duration.ofMillis(100))
        .click()
        .perform();
		handleMSAccountSelection();
		WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'successfully') or contains(text(),'Success') or contains(text(),'connected')]")));
		Assert.assertTrue(successToast.isDisplayed(),"Connection failed");

	}


	private void handleMSAccountSelection() throws InterruptedException {

		// 1️⃣ Store parent window
		String parentWindow = driver.getWindowHandle();

		// 2️⃣ Switch to Microsoft login window
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5))
			.until(ExpectedConditions.or(
					ExpectedConditions.presenceOfElementLocated(myMSAcc),
					ExpectedConditions.presenceOfElementLocated(By.id("i0116")) // email field
					));
		} catch (Exception ignored) {}


		List<WebElement> accounts = driver.findElements(myMSAcc);

		if (!accounts.isEmpty()) {
			System.out.println("Existing Microsoft account found, clicking it");
			wait.until(ExpectedConditions.elementToBeClickable(accounts.get(0))).click();
		} else {
			System.out.println("No existing account found, starting MS login");
			MSLogin();
		}

		driver.switchTo().window(parentWindow);
	}


	private void MSLogin() throws InterruptedException {

		MSLogin passwordPage = new MSLogin(driver);
		passwordPage.enterEmail();
		passwordPage.enterPassword("Mow078256");
		passwordPage.clickSignIn();

		// Wait for Authenticator approval to complete
		AuthenticationPage authPage = new AuthenticationPage(driver);
		authPage.waitForYes();

		StaySignedInPage stayPage = new StaySignedInPage(driver);
		// Handle Stay Signed In page
		try {

			stayPage.clickYes();
			// Wait for final redirect to your app’s home page

		} catch (Exception e) {
			System.out.println("Stay signed in page not shown this time — continuing...");
		}


		System.out.println("Microsoft Login flow completed");
	}
	
}
