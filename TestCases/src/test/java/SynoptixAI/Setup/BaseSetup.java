package SynoptixAI.Setup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
            // 2️⃣ Configure Chrome options
           // ChromeOptions options = new ChromeOptions();
            //options.addArguments("--start-maximized");                // open full screen
            //options.addArguments("--force-device-scale-factor=0.9");  // set zoom to 80%

            // 3️⃣ Launch Chrome with options
           // driver = new ChromeDriver(options);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
           // driver.get("https://app.synoptix.ai/");
            driver.get("https://app.synoptix.ai//");
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

