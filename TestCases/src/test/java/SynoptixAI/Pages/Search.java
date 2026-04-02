package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
	WebDriver driver;
	WebDriverWait wait;
	
	private By newChatBtnLoc=By.xpath("//span[normalize-space()='New Chat']");
	private By promptFieldLoc=By.xpath("//textarea[@id='synoptix-message-input']");
	
	
	
	public Search(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

}
