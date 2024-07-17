package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCommentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By userNameBox = By.name("username");
    private By passBox = By.name("password");
    private By loginButton = By.cssSelector("button.btn.btn-primary.col-md-12");
    private By detailButton = By.cssSelector("a.shadow__btn.mt-auto[href='/movie/book/1']");
    private By comment = By.id("comment");
    private By star1Label = By.cssSelector("label[for='star1']");
    private By star2Label = By.cssSelector("label[for='star2']");
    private By star3Label = By.cssSelector("label[for='star3']");
    private By star4Label = By.cssSelector("label[for='star4']");
    private By star5Label = By.cssSelector("label[for='star5']");
    private By submitButton = By.cssSelector("button.button2");
//    private By screeningRoomLink = By.cssSelector("a.manage[href='/movie/book/1']");
//    private By addNewScreeningRoomButton = By.cssSelector("a.btn.btn-primary[href='/screeningroom/new']");

    // Constructor
    public AddCommentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page actions
    public void enterUsername(String username) {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBox));
        userNameElement.sendKeys(username);
    }

    public void enterPass(String password) {
        WebElement passElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passBox));
        passElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    public void getDetailButton() {
        WebElement detailButtonElement = wait.until(ExpectedConditions.elementToBeClickable(detailButton));
        detailButtonElement.click();
    }

    public void getComment(String key) {
        WebElement commentElement = wait.until(ExpectedConditions.elementToBeClickable(comment));
        commentElement.sendKeys(key);
    }

    public void clickStar1() {
        WebElement star1Element = wait.until(ExpectedConditions.elementToBeClickable(star1Label));
        star1Element.click();
    }

    public void clickStar2() {
        WebElement star2Element = wait.until(ExpectedConditions.elementToBeClickable(star2Label));
        star2Element.click();
    }

    public void clickStar3() {
        WebElement star3Element = wait.until(ExpectedConditions.elementToBeClickable(star3Label));
        star3Element.click();
    }

    public void clickStar4() {
        WebElement star4Element = wait.until(ExpectedConditions.elementToBeClickable(star4Label));
        star4Element.click();
    }

    public void clickStar5() {
        WebElement star5Element = wait.until(ExpectedConditions.elementToBeClickable(star5Label));
        star5Element.click();
    }

    public void clickSubmitButton() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submit.click();
    }
}
