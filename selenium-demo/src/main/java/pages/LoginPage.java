package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators for demo site
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By successMessage = By.id("flash");
    By errorMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enter a username into the username field on the login page.
     * 
     * @param user The username to enter
     */
    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    /**
     * Enter a password into the password field on the login page.
     * 
     * @param pass The password to enter
     */
    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    /**
     * Click the login button on the login page.
     * 
     * This method clicks the login button, which will attempt to log in with the entered username and password.
     */
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Check if the login was successful by verifying if the current URL contains "/secure"
     * 
     * @return true if the login was successful, false otherwise
     */
    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("/secure");
    }

    /**
     * Check if an error message is displayed on the login page.
     * 
     * This method checks if an error message is displayed on the login page, which will be visible if the login attempt was unsuccessful.
     * 
     * @return true if an error message is displayed, false otherwise
     */
    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    /**
     * Retrieve the text of the success message after a successful login.
     * 
     * This method retrieves the text of the success message that is displayed after a successful login.
     * 
     * @return The text of the success message
     */
    public String getMessageText() {
        return driver.findElement(successMessage).getText();
    }
}
