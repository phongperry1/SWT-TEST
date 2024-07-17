import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChangepassPage;

import java.time.Duration;

public class ChangepassTest {
    private WebDriver driver;
    private ChangepassPage changepassPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        changepassPage = new ChangepassPage(driver);
    }
    @Test
    public void testChangePassword1() {
        ChangepassPage changepassPage = new ChangepassPage(driver);
        changepassPage.enterUsername("phongnnde170641@fpt.edu.vn");
        changepassPage.enterPass("123456789");
        changepassPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:8080/user/home"));
        changepassPage.clickOnAvatarImage();
        changepassPage.clickDropdownToggle();
        changepassPage.clickChangePasswordLink();
        ////Test New password and confirm password do not match
        changepassPage.enterCurrentPassword("123456789");
        changepassPage.enterNewPassword("123456");
        changepassPage.confirmNewPassword("Hieu12345");
        changepassPage.clickSaveChangeButton();
    }
    @Test
    public void testChangePassword2() {
        ChangepassPage changepassPage = new ChangepassPage(driver);
        changepassPage.enterUsername("phongnnde170641@fpt.edu.vn");
        changepassPage.enterPass("123456789");
        changepassPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:8080/user/home"));
        changepassPage.clickOnAvatarImage();
        changepassPage.clickDropdownToggle();
        changepassPage.clickChangePasswordLink();
        ////////Test Current password is incorrect
        changepassPage.enterCurrentPassword("Luxyanna2");
        changepassPage.enterNewPassword("Hieu922017");
        changepassPage.confirmNewPassword("Hieu922017");
        changepassPage.clickSaveChangeButton();
    }

    @Test
    public void testChangePassword3() {
        ChangepassPage changepassPage = new ChangepassPage(driver);
        changepassPage.enterUsername("phongnnde170641@fpt.edu.vn");
        changepassPage.enterPass("123456789");
        changepassPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:8080/user/home"));
        changepassPage.clickOnAvatarImage();
        changepassPage.clickDropdownToggle();
        changepassPage.clickChangePasswordLink();
        ////////Test Change password successfully
        changepassPage.enterCurrentPassword("123456789");  ///correct current password
        changepassPage.enterNewPassword("123456");
        changepassPage.confirmNewPassword("123456");
        changepassPage.clickSaveChangeButton();
    }

    @Test
    public void testChangePassword4() {
        ChangepassPage changepassPage = new ChangepassPage(driver);
        changepassPage.enterUsername("phongnnde170641@fpt.edu.vn");
        changepassPage.enterPass("123456789");
        changepassPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:8080/user/home"));
        changepassPage.clickOnAvatarImage();
        changepassPage.clickDropdownToggle();
        changepassPage.clickChangePasswordLink();
        ////////Test Input do not meet "Password Complexity Requirements" 
        changepassPage.enterCurrentPassword("123456");
        changepassPage.enterNewPassword("hieu1");
        changepassPage.confirmNewPassword("Hieu1");
        changepassPage.clickSaveChangeButton();
    }

}