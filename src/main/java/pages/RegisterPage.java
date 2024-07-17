package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "userName")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "userPassword")
    private WebElement passwordField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost:8080/register");
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName")));
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userPassword")));
        passwordField.sendKeys(password);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("phone")));
        phoneField.sendKeys(phone);
    }

    public boolean isRegisterButtonEnabled() {
        return registerButton.isEnabled();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForUrl(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
