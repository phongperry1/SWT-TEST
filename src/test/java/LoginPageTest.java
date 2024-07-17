import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {
    private WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void LoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("vomailamvy@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/user/home"));
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:8080/user/home", "Login was not successful.");
    }
    @Test
    public void LoginSuccessfulwithAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("namphongfpt2003@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/show"));
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:8080/show", "Login was not successful.");
    }
    @Test
    public void LoginSuccessfulwithCinemaOwner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("namphongbku2111@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/cinemaowner/homecinemaowner"));
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:8080/cinemaowner/homecinemaowner", "Login was not successful.");
    }

    @Test
    public void LoginFailUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("vo@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message']")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        assertTrue(errorMessage.getText().contains("Invalid username or password") || errorMessage.getText().contains("Bad credentials"), "Error message text is incorrect.");
    }
    @Test
    public void LoginFailPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("vomailamvy@gmail.com");
        loginPage.enterPassword("1234");
        loginPage.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message']")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        assertTrue(errorMessage.getText().contains("Invalid username or password") || errorMessage.getText().contains("Bad credentials"), "Error message text is incorrect.");
    }
    @Test
    public void LoginFailUsernameAndPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("vo@gmail.com");
        loginPage.enterPassword("12344");
        loginPage.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message']")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        assertTrue(errorMessage.getText().contains("Invalid username or password") || errorMessage.getText().contains("Bad credentials"), "Error message text is incorrect.");
    }
    @Test
    public void LoginNull() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message']")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        assertTrue(errorMessage.getText().contains("Invalid username or password") || errorMessage.getText().contains("Bad credentials"), "Error message text is incorrect.");
    }

    @Test
    public void LoginNullUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message']")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        assertTrue(errorMessage.getText().contains("Invalid username or password") || errorMessage.getText().contains("Bad credentials"), "Error message text is incorrect.");
    }

    @Test
    public void LoginNullPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("vomailamvy@gmail.com");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error-message']")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
        assertTrue(errorMessage.getText().contains("Invalid username or password") || errorMessage.getText().contains("Bad credentials"), "Error message text is incorrect.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



