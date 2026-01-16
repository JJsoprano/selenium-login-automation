package testmouse;

import java.awt.*;
import java.awt.event.KeyEvent;
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

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Add Element']")
            )
        );

        addBtn.click();

        // Add Robot code here
        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try { Thread.sleep(3000); } catch (Exception ignored) {}
        driver.quit();
    }
}
