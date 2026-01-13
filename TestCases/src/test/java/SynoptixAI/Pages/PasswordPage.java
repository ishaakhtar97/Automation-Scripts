package SynoptixAI.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By passwordInput = By.name("Passwd");
    private By signInBtn=By.xpath("//span[normalize-space()='Next']");
    //private By signInBtn = By.id("idSIButton9");

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Actions
    public void enterPassword(String password) {
        WebElement pwdField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        pwdField.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInButton.click();
    }
}
