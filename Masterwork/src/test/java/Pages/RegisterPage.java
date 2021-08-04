package Pages;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPage extends HomePage{

    @FindBy(id = "input-firstname")
    WebElement firstNameTextField;

    @FindBy(id = "input-lastname")
    WebElement lastNameTextField;

    @FindBy(id = "input-email")
    WebElement emailTextField;

    @FindBy(id = "input-telephone")
    WebElement telephoneTextField;

    @FindBy(id = "input-password")
    WebElement passwordTextField;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirmTextField;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")
    WebElement newsletterSubscribeRadioButtonNo;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
    WebElement newsletterSubscribeRadioButtonYes;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/a")
    WebElement privacyPolicy;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    WebElement privacyAlert;

    Random random = new Random();



    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Register Account"));
    }


    public void unsuccessfulRegistration(String firstName, String lastName, String email,
                                      String telephone, String password, String passwordConfirm) {
        firstNameTextField.sendKeys(firstName);
        lastNameTextField.sendKeys(lastName);
        emailTextField.sendKeys(email);
        telephoneTextField.sendKeys(telephone);
        passwordTextField.sendKeys(password);
        passwordConfirmTextField.sendKeys(passwordConfirm);
        newsletterSubscribeRadioButtonNo.click();
        continueButton.click();
    }

    public void successfulRegistration(String firstName, String lastName, String email,
                                         String telephone, String password, String passwordConfirm) {
        firstNameTextField.sendKeys(firstName);
        lastNameTextField.sendKeys(lastName);
        emailTextField.sendKeys(email);
        telephoneTextField.sendKeys(telephone);
        passwordTextField.sendKeys(password);
        passwordConfirmTextField.sendKeys(passwordConfirm);
        newsletterSubscribeRadioButtonNo.click();
        privacyPolicyCheckbox.click();
        continueButton.click();
    }

    public void readPrivacyPolicy() {
        privacyPolicy.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"modal-agree\"]/div/div/div[1]/button"));
        closeButton.click();

    }

    public boolean privacyAlertDisplay() {
        return wait.until(ExpectedConditions.visibilityOf(privacyAlert)).isDisplayed();
    }


}
