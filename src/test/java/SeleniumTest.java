import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCommentPage;

import java.time.Duration;

public class SeleniumTest {
    private WebDriver driver;
    private AddCommentPage addScreenRoomPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        addScreenRoomPage = new AddCommentPage(driver);
    }


    @Test
    public void testLogin() {
        addScreenRoomPage.enterUsername("phongnnde170641@fpt.edu.vn");
        addScreenRoomPage.enterPass("123456789");
        addScreenRoomPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:8080/user/home"));

        addScreenRoomPage.getDetailButton();
        addScreenRoomPage.getComment("Phim Hay");
        addScreenRoomPage.clickStar3();
        addScreenRoomPage.clickSubmitButton();

    }
}
