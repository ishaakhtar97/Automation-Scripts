package SynoptixAI.Setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseSetup {
    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setupSuite() throws InterruptedException {
        if (driver == null) {
            System.out.println(">>> Launching browser...");
            
            //Chrome browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
             
            
            //Edge browser
           // System.setProperty("webdriver.edge.driver", "C:\\Users\\IshaAkhtar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            // driver = new EdgeDriver();
             
            driver.manage().window().maximize();
            //((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
            driver.manage().deleteAllCookies();
           // driver.get("https://app.synoptix.ai/");
            driver.get("https://app.synoptix.ai/");
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

