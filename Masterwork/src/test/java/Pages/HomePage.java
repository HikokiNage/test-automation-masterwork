package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    WebElement span;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    WebElement loginButton;

    @FindBy(id = "button-cart")
    WebElement buttonCart;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        js = ((JavascriptExecutor) driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://test-automation-shop2.greenfox.academy/");
    }

    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Your Store"));
    }

    public RegisterPage navigateToRegisterPage() {
        span.click();
        wait.until(ExpectedConditions.visibilityOf(registerButton)).isDisplayed();
        registerButton.click();


        return new RegisterPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        span.click();
        wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
        loginButton.click();
        
        return new LoginPage(driver);
    }

    public void addToChart() {
        List<WebElement> products = new ArrayList<>(driver.
                findElements(By.));

        for (WebElement product : products) {
            product.click();
            buttonCart.click();
        }
    }

}
