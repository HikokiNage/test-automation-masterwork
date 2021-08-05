package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessRegisterPage extends RegisterPage{

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement continueButton;

    public WebElement getContinueButton() {
        return continueButton;
    }

    public SuccessRegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Your Account Has Been Created!"));
    }
}
