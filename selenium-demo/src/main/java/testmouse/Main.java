package testmouse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    /**
     * Main entry point for the application.
     * 
     * This program automates a login test on The Internet demo website using Selenium WebDriver.
     * It uses ChromeDriver and sets up the browser to maximize the window.
     * It then navigates to the login page, enters a username and password, clicks the login button, and verifies the success message.
     * Finally, it prints the success message to the console and quits the browser.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        final String chromeDriverPath = "C:\\drivers\\chromedriver-win64\\chromedriver.exe";
        final String url = "https://the-internet.herokuapp.com/login";
        final String username = "tomsmith";
        final String password = "SuperSecretPassword!";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get(url);

            // Enter username
            WebElement usernameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
            );
            usernameElement.sendKeys(username);

            // Enter password
            WebElement passwordElement = driver.findElement(By.id("password"));
            passwordElement.sendKeys(password);

            // Click login
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Verify login success
            WebElement successElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
            );

            System.out.println(successElement.getText());
        } finally {
            driver.quit();
        }
    }
}
