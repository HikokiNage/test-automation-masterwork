package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import static org.assertj.core.api.Assertions.*;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Login")
public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeEach
    public void goToLoginPage() {
        homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        loginPage = homePage.navigateToLoginPage();
        loginPage.isLoaded();
    }

    @Test
    @DisplayName("Unsuccessful login")
    @Description("The user don't add username and password.")
    public void unSuccessfulLogin() {
        loginPage.login("", "");
        assertThat(loginPage.getAlertMessage().isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Successful login")
    @Description("The user successfully logged in.")
    public void SuccessfulLogin() {
        loginPage.login("tesztandras@gmail.com", "Teszt123");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.isLoaded();
    }
}
