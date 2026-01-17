package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class LoginTest {


/**
 * Test successful login to the-internet demo website.
 * 
 * 1. Set up ChromeDriver
 * 2. Navigate to the login page
 * 3. Enter valid username and password
 * 4. Click the login button
 * 5. Assert that the success message contains "You logged into a secure area".
 * 6. Quit the browser
 */
    @Test
    public void testLoginSuccess() {
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\drivers\\chromedriver-win64\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage login = new LoginPage(driver);
        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();

        // ✅ ASSERTION
        WebElement successMessage =
            driver.findElement(By.id("flash"));

        Assertions.assertContains(
            successMessage.getText(),
            "You logged into a secure area",
            "Login failed!"
        );

        System.out.println("✅ Login assertion passed");

        driver.quit();
    }
}
