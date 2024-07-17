package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangepassPage {
    private WebDriver driver;

    // Locators
    private By userNameBox = By.name("username");
    private By passBox = By.name("password");
    private By loginButton = By.cssSelector("button.btn.btn-primary.col-md-12");
    private By dropdownToggle = By.cssSelector("a.dropdown-toggle");
    private By changePasswordLink = By.cssSelector("a.dropdown-item[href='/user/change-password']");
    private By curPasswordInput = By.id("curPassword");
    private By newPasswordInput = By.id("newPassword");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By saveChangeButton = By.cssSelector("button.btn.btn-secondary.mt-5.mb-5.col-2");

    public ChangepassPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement userNameElement = driver.findElement(userNameBox);
        userNameElement.sendKeys(username);
    }

    public void enterPass(String password) {
        WebElement passElement = driver.findElement(passBox);
        passElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public void clickOnAvatarImage() {
        WebElement avatarElement = findAvatarImage();
        avatarElement.click();
    }

    private WebElement findAvatarImage() {
        return driver.findElement(By.cssSelector("img[alt='Avatar']"));
    }

    public void clickDropdownToggle() {
        driver.findElement(dropdownToggle).click();
    }

    public void clickChangePasswordLink() {
        driver.findElement(changePasswordLink).click();
    }

    public void enterCurrentPassword(String password) {
        WebElement curPasswordElement = driver.findElement(curPasswordInput);
        curPasswordElement.sendKeys(password);
    }

    public void enterNewPassword(String password) {
        WebElement newPasswordElement = driver.findElement(newPasswordInput);
        newPasswordElement.sendKeys(password);
    }

    public void confirmNewPassword(String password) {
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordInput);
        confirmPasswordElement.sendKeys(password);
    }

    public void clickSaveChangeButton() {
        WebElement saveChangeButtonElement = driver.findElement(saveChangeButton);
        saveChangeButtonElement.click();
    }
}

