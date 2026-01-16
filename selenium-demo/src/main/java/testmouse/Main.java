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

        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\drivers\\chromedriver-win64\\chromedriver.exe"
        );

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/login");

        // Enter username
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );
        username.sendKeys("tomsmith");

        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        // Click login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify login success
        WebElement success = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );

        System.out.println(success.getText());

        driver.quit();
    }
}
