package browserfactory;
/**
 * Create the package ‘browserfactory’ and create the  class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup  code inside the class ‘Base Test’.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    static String browser = "Chrome"; // declaring and assigning value for the browser selection
    public static WebDriver driver; //

    public void openBrowser(String baseUrl) {
        if (browser.trim().equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver(); // object creation for Chrome browser
        } else if (browser.trim().equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver(); // object creation for Firefox browser
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver(); // object creation for Edge browser
        } else {
            System.out.println("Wrong Browser Name");
        }

        driver.get(baseUrl); // open the base URL in the selected browse
        driver.manage().window().maximize(); // maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // wait for certain amount, so the link can load fully
    }

    public void closeBrowser() {
        driver.quit(); // close the browser
    }
}