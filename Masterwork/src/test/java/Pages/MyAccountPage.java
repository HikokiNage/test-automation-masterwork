package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAccountPage extends HomePage{

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
    WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[2]")
    WebElement editAccount;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[3]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[4]")
    WebElement addressBook;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[5]")
    WebElement wishList;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[6]")
    WebElement orderHistory;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[7]")
    WebElement downloads;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[8]")
    WebElement recurringPayments;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[9]")
    WebElement rewardPoints;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[10]")
    WebElement returns;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[11]")
    WebElement transactions;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[12]")
    WebElement newsletter;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
    WebElement logout;

    @FindBy(xpath = "//*[@id=\"account-account\"]/div[1]")
    WebElement successMessage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("My Account"));
    }

    public boolean successMessageDisplay() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }

    public PasswordPage navigateToPasswordPage() {
        password.click();

        return new PasswordPage(driver);
    }

    public void logout() {
        logout.click();
    }
}
