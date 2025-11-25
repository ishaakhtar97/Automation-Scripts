package SynoptixAI.Pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Users {
	
	WebDriver driver;
	WebDriverWait wait;

	private By mgmntCentre=By.xpath("//span[normalize-space()='Management Center']");
	private By usersMenu=By.xpath("(//div)[14]");
	private By usersPage=By.xpath("(//span[normalize-space()='Users'])[2]");
	private By guestPage=By.xpath("//span[normalize-space()='Guests']");
	private By addUsersBtn=By.xpath("//button[normalize-space()='Add User']");
	private By addGuestBtn=By.xpath("//button[normalize-space()='Add Guest User']");
	private By userName=By.xpath("//input[@id='displayName']");
	private By email=By.xpath("//input[@id='email']");
	private By guestEmail=By.xpath("//input[@id='userPrincipalName']");
	private By submit=By.xpath("//button[@type='submit']");
	private By guestSubmit=By.xpath("//button[normalize-space()='Invite Guest']");
	
	
	public Users(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void addUserFunc() throws InterruptedException
	{
		WebElement mngmntMenu = wait.until(ExpectedConditions.elementToBeClickable(mgmntCentre));
		mngmntMenu.click();
		Thread.sleep(1000);
		WebElement users = wait.until(ExpectedConditions.elementToBeClickable(usersMenu));
		users.click();
		WebElement addUserPage = wait.until(ExpectedConditions.elementToBeClickable(usersPage));
		addUserPage.click();
		Thread.sleep(1000);
		WebElement addUser = wait.until(ExpectedConditions.elementToBeClickable(addUsersBtn));
		addUser.click();
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(userName));
		name.click();
		Random rand = new Random();
		int randomNum = rand.nextInt(1000);
		String uniqueName = "TestUser_" + randomNum;
		name.sendKeys(uniqueName);
		WebElement userEmail = wait.until(ExpectedConditions.elementToBeClickable(email));
		userEmail.click();
		String uniqueEmail = "user" +randomNum + "@synoptix.ai";
		userEmail.sendKeys(uniqueEmail);
		Thread.sleep(1000);
		WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
		submitBtn.click();
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'Successfully added')")
					));

			System.out.println("User Added " + successToast.getText());

		} catch (Exception e) {
			System.out.println("User may not get added");
		}
	}
	
	public void addGuestFunc() throws InterruptedException
	{
		//WebElement mngmntMenu = wait.until(ExpectedConditions.elementToBeClickable(mgmntCentre));
		//mngmntMenu.click();
		//WebElement users = wait.until(ExpectedConditions.elementToBeClickable(usersMenu));
		//users.click();
		Thread.sleep(1000);
		WebElement addGuestPage = wait.until(ExpectedConditions.elementToBeClickable(guestPage));
		addGuestPage.click();
		Thread.sleep(1000);
		WebElement addGuestUser = wait.until(ExpectedConditions.elementToBeClickable(addGuestBtn));
		addGuestUser.click();
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(userName));
		name.click();
		Random rand = new Random();
		int randomNum = rand.nextInt(1000);
		String uniqueName = "Guest User_" + randomNum;
		name.sendKeys(uniqueName);
		WebElement userEmail = wait.until(ExpectedConditions.elementToBeClickable(guestEmail));
		userEmail.click();
		String uniqueEmail = "user" +randomNum + "@gmail.com";
		userEmail.sendKeys(uniqueEmail);
		Thread.sleep(1000);
		WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(guestSubmit));
		submitBtn.click();
		try {
			// Use a flexible locator since toast notifications usually have changing structure
			WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(text(),'Successfully invited')")
					));

			System.out.println("Guest Added " + successToast.getText());

		} catch (Exception e) {
			System.out.println("Guest may not get added");
		}
	}
	
	
}
