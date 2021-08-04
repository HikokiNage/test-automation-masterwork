package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccount extends HomePage{

    @FindBy(id = "input-telephone")
    WebElement telephoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    WebElement continueButton;

    public EditAccount(WebDriver driver) {
        super(driver);
    }

    public void changePhoneNumber(String newPhoneNumber) {
        telephoneInput.clear();
        telephoneInput.sendKeys(newPhoneNumber);
        continueButton.click();
    }
}
