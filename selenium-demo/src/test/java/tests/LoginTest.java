package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    /**
     * Test that a valid login attempt results in a successful login.
     * 
     * This test enters valid credentials on the login page, clicks the login button, and verifies that the user is redirected to the secure page.
     * 
     * @see #enterUsername(String)
     * @see #enterPassword(String)
     * @see #clickLogin()
     * @see #isLoginSuccessful()
     */
    @Test
    public void testValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        // Valid credentials for demo site
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        Assertions.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed: User was not redirected to secure page"
        );
    }

    /**
     * Test that an invalid login attempt results in an error message being displayed.
     * 
     * This test enters invalid credentials on the login page, clicks the login button, and verifies that an error message is displayed.
     * 
     * @see #enterUsername(String)
     * @see #enterPassword(String)
     * @see #clickLogin()
     * @see #isErrorDisplayed()
     */
    @Test
    public void testInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        Assertions.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message not displayed for invalid login"
        );
    }
}
