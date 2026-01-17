package testmouse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        final String chromeDriverPath = "C:\\drivers\\chromedriver-win64\\chromedriver.exe";
        final String url = "https://the-internet.herokuapp.com/login";
        final String username = "tomsmith";
        final String password = "SuperSecretPassword!";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        try (WebDriver driver = new ChromeDriver()) {
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
        }
    }
}
