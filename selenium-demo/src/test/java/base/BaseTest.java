package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    /**
     * Set up the test environment by creating a new ChromeDriver instance, maximizing the window, and set the implicit wait to 10 seconds.
     * It then navigates to the login page.
     * This method is called before each test.
     */
    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Change this to YOUR login page
        driver.get("https://the-internet.herokuapp.com/login");
    }

    /**
     * Tear down the test environment by quitting the WebDriver instance.
     * This method is called after each test.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
