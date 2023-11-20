package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValidCredentials
 *      Enter “tomsmith” username
 *      Enter “SuperSecretPassword!” password
 *      Click on ‘LOGIN’ button
 *      Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 *      Enter “tomsmith1” username
 *      Enter “SuperSecretPassword!” password
 *      Click on ‘LOGIN’ button
 *      Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 *      Enter “tomsmith” username
 *      Enter “SuperSecretPassword” password
 *      Click on ‘LOGIN’ button
 *      Verify the error message “Your password is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseUrl = "http://the-internet.herokuapp.com/login"; // base URL

    @Before
    public void setUp () {
        openBrowser(baseUrl); // calling method from BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); // find element for username field and enter valid username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); // find element for Password field and enter valid password
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();  // find element for Login button and click
        // find the text element in the re-directed page to verify successfully login
        String actualText = driver.findElement(By.xpath("//h2[contains(text(), ' Secure Area' )]")).getText();
        String expectedText = "Secure Area";  // expected text
        Assert.assertEquals(expectedText, actualText);  // verify expected and actual text
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith1"); // find element for username field and enter in-valid username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); // find element for Password field and enter valid password
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();  // find element for Login button and click
        // find the text element in the error message
        String actualText = driver.findElement(By.xpath("//div[@id = 'flash-messages']")).getText();
        String expectedText = "Your username is invalid!\n×";  // expected text
        Assert.assertEquals(expectedText, actualText);  // verify expected and actual text
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); // find element for username field and enter valid username
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword"); // find element for Password field and enter in-valid password
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();  // find element for Login button and click
        // find the text element in the error message
        String actualText = driver.findElement(By.xpath("//div[@id = 'flash-messages']")).getText();
        String expectedText = "Your password is invalid!\n×";  // expected text
        Assert.assertEquals(expectedText, actualText);  // verify expected and actual text
    }

    @After
    public void tearTown () {
        closeBrowser(); // calling method from BaseTest class to close the browser
    }
}
