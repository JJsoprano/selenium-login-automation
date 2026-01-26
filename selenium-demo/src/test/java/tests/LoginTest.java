package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;


/*************  ✨ Windsurf Command ⭐  *************/
    /**
     * Set up the test environment by creating a new ChromeDriver instance, maximizing the window, navigate to the login page, and create a new LoginPage instance.
     * This method is called before each test.
     */
/*******  5b09f901-351a-4772-b7e4-604ece38c4dd  *******/    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);
    }

    @Test
    void validLoginShouldSucceed() throws Exception {
        loginPage.enterUsername("tomsmith")
                 .enterPassword("SuperSecretPassword!")
                 .clickLogin();

        // Wait for redirect to complete
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/secure"));

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
