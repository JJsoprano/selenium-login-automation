package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    /**
     * Enter username in the login form
     * @param user username to enter
     */
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    /**
     * Enter password in the login form
     * @param pass password to enter
     */
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    /**
     * Click the login button
     */
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}
