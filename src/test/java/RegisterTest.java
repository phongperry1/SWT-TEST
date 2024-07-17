import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testValidRegistration() {
        registerPage.open();

        registerPage.enterName("Test User");
        registerPage.enterEmail("testuser@example.com");
        registerPage.enterPassword("password123");
        registerPage.enterPhone("1234567890");

        assertTrue(registerPage.isRegisterButtonEnabled());

        registerPage.clickRegisterButton();

        registerPage.waitForUrl("http://localhost:8080/guest/");
        assertEquals("http://localhost:8080/guest/", registerPage.getCurrentUrl(), "Registration redirection failed.");
    }

    @Test
    public void testShortPassword() {
        registerPage.open();

        registerPage.enterName("Test User");
        registerPage.enterEmail("testuser@example.com");
        registerPage.enterPassword("1");
        registerPage.enterPhone("1234567890");

        assertTrue(registerPage.isRegisterButtonEnabled());

        registerPage.clickRegisterButton();

        registerPage.waitForUrl("http://localhost:8080/guest/");
        assertEquals("http://localhost:8080/guest/", registerPage.getCurrentUrl(), "Registration redirection failed.");
    }

    @Test
    public void testEmptyEmail() {
        registerPage.open();

        registerPage.enterName("Test User");
        registerPage.enterEmail("");
        registerPage.enterPassword("password123");
        registerPage.enterPhone("1234567890");

        assertTrue(registerPage.isRegisterButtonEnabled());

        registerPage.clickRegisterButton();

        registerPage.waitForUrl("http://localhost:8080/guest/");
        assertEquals("http://localhost:8080/guest/", registerPage.getCurrentUrl(), "Registration redirection failed.");
    }

    @Test
    public void testEmptyPhone() {
        registerPage.open();

        registerPage.enterName("Test User");
        registerPage.enterEmail("testuser@example.com");
        registerPage.enterPassword("password123");
        registerPage.enterPhone("");

        assertTrue(!registerPage.isRegisterButtonEnabled());

        registerPage.enterPassword("correctLen");

        assertTrue(registerPage.isRegisterButtonEnabled());

        registerPage.clickRegisterButton();

        registerPage.waitForUrl("http://localhost:8080/guest/");
        assertEquals("http://localhost:8080/guest/", registerPage.getCurrentUrl(), "Login was not successful.");
    }
}
