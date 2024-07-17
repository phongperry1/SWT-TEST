package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    // Xác định các phần tử web
    @FindBy(id = "email")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "button.btn-primary")
    WebElement loginButton;

    // Xác định các phần tử web cho tìm kiếm
    @FindBy(className = "input")
    WebElement searchField;

    @FindBy(className = "custom-btn3")
    WebElement searchButton;

    // Khởi tạo lớp POM
    public SearchPage(WebDriver driver) {
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

    // Phương thức nhập tìm kiếm
    public void enterSearchQuery(String query) {
        searchField.sendKeys(query);
    }

    // Phương thức nhấn nút tìm kiếm
    public void clickSearchButton() {
        searchButton.click();
    }
}
