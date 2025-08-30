package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {

    WebDriver browser;

    @BeforeSuite
    public void openBrowser() {
        browser = new ChromeDriver();
    }

    @AfterSuite
    public void closeBrowser() {
        browser.quit();
    }

    public WebDriver getBrowser(String browser_name) {
        if (browser_name.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (browser_name.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else if (browser_name.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser is not available with the given name: " + browser_name);
        }
    }
}
