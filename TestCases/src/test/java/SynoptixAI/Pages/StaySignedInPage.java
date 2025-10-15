package SynoptixAI.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StaySignedInPage {
	WebDriver driver;
    WebDriverWait wait;

    private By yesButton = By.id("idSIButton9"); // "Yes" button on Stay signed in page
    private By dashboardElement = By.xpath("//img[@class='object-cover']"); 

    public StaySignedInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickYes() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }
    
    
	public void waitForLoginCompletion() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElement));
	}

	

}
