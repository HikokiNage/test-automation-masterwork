package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends HomePage{

    @FindBy(id = "input-email")
    WebElement emailInput;

    @FindBy(id = "input-password")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    WebElement alertMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Account Login"));
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }
}
