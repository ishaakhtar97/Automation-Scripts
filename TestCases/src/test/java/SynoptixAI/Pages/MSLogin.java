package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MSLogin {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
  
    private By emailInput = By.xpath("//input[@id='i0116']");
    private By nextBtn=By.xpath("//input[@id='idSIButton9']");
    private By passwordInput = By.xpath("//input[@id='i0118']");
    private By signInBtn=By.xpath("//input[@id='idSIButton9']");
    //private By signInBtn = By.id("idSIButton9");

    public MSLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Actions
    
    public void enterEmail() {
    	wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys("isha.akhtar@synoptix.ai");
    	wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }
    
    public void enterPassword(String password) {
    	
        WebElement pwdField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        pwdField.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInButton.click();
    }
}
