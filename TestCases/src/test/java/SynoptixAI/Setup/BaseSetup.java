package SynoptixAI.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseSetup {
    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setupSuite() throws InterruptedException {
        if (driver == null) {
            System.out.println(">>> Launching browser...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
           // driver.get("https://app.synoptix.ai/");
            driver.get("https://testing.synoptix.ai/");
            Thread.sleep(5000);
            System.out.println(">>> Browser launched successfully!");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

   /* @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        if (driver != null) {
            System.out.println(">>> Closing browser...");
            driver.quit();
            driver = null;
        }*/
  }

