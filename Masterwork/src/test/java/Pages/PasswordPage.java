package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends HomePage{

    @FindBy(id = "input-password")
    WebElement passwordInput;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    WebElement continueButton;

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public void changePassword(String newPassword) {
        passwordInput.sendKeys(newPassword);
        confirmPasswordInput.sendKeys(newPassword);
        continueButton.click();
    }
}
