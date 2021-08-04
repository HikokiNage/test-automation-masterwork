package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutPage extends HomePage{

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Account Logout"));
    }
}
