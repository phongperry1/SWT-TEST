package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Xác định các phần tử web
    @FindBy(id = "email")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "button.btn-primary")
    WebElement loginButton;

    // Khởi tạo lớp POM
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Phương thức nhập username
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    // Phương thức nhập password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Phương thức nhấn nút đăng nhập
    public void clickLoginButton() {
        loginButton.click();
    }
}
