package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By successMessage = By.id("flash");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    /**
     * Enter the username for the login form.
     * 
     * Waits for the username input field to be visible, then enters the given username into the field.
     * 
     * @param user The username to enter into the login form.
     */
    public LoginPage enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
            .sendKeys(user);
        return this;
    }

    /**
     * Enter the password for the login form.
     * 
     * Waits for the password input field to be visible, then enters the given password into the field.
     * 
     * @param pass The password to enter into the login form.
     */
    public LoginPage enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
            .sendKeys(pass);
        return this;
    }

    /**
     * Click the login button.
     * 
     * Waits for the login button to be clickable, then clicks it.
     */
    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return this;
    }
    /**
 * Get the success message text after login.
 *
 * @return success message text
 */
public String getSuccessMessage() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage))
               .getText();
}

}
