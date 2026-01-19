package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);
    }

    @Test
    void validLoginShouldSucceed() throws Exception {
        // Use Selenium for username
        loginPage.enterUsername("tomsmith");

        // Use Robot for password typing
        Robot robot = new Robot();
        robot.delay(500);

        for (char c : "SuperSecretPassword!".toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }

        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Assertion: URL contains /secure
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("/secure"),
                "User was not redirected to secure page"
        );

        // Assertion: success message visible
        Assertions.assertTrue(
                loginPage.getSuccessMessage().contains("You logged into a secure area"),
                "Login success message not found"
        );
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
