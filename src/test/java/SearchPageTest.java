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
import pages.SearchPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPageTest {
    private WebDriver driver;
    SearchPage loginPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        loginPage = new SearchPage(driver);
    }

    @Test
    public void SearchSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("phongnnde170641@fpt.edu.vn");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/user/home"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/user/home", currentUrl, "Login was not successful.");

        loginPage.enterSearchQuery("kẻ trộm mặt trăng");
        loginPage.clickSearchButton();

        wait.until(ExpectedConditions.urlContains("search"));
        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("search"), "Search was not successful.");
    }
    @Test
    public void Emptysearchl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("phongnnde170641@fpt.edu.vn");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/user/home"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/user/home", currentUrl, "Login was not successful.");

        loginPage.enterSearchQuery("");
        loginPage.clickSearchButton();

        wait.until(ExpectedConditions.urlContains("search"));
        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("search"), "Search was not successful.");
    }
    @Test
    public void searchdidnotfind() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("phongnnde170641@fpt.edu.vn");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/user/home"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/user/home", currentUrl, "Login was not successful.");

        loginPage.enterSearchQuery("jujutsu");
        loginPage.clickSearchButton();

        wait.until(ExpectedConditions.urlContains("search"));
        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("search"), "Search was not successful.");
    }
    @Test
    public void specialcharacters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8080/login");
        loginPage.enterUsername("phongnnde170641@fpt.edu.vn");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/user/home"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/user/home", currentUrl, "Login was not successful.");

        loginPage.enterSearchQuery("@@@@@");
        loginPage.clickSearchButton();

        wait.until(ExpectedConditions.urlContains("search"));
        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("search"), "Search was not successful.");
    }}
