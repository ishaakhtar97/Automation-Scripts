package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
   private By emailInput = By.xpath("//input[@placeholder='Enter your email address']");
   
   private By passwordInput = By.xpath("//input[@placeholder='Password']");
   private By nextBtn = By.xpath("//button[contains(text(),'Login')]");
    
    

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


	// Actions
    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailField.sendKeys(email);
    }
    
 // Actions
    public void enterPassword(String password) {
        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passField.sendKeys(password);
    }


    public void Login() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextButton.click();
    }
}
