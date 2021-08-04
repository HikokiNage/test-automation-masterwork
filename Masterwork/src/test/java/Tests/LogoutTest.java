package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Logout")
public class LogoutTest extends BaseTest{

    @Test
    @DisplayName("Success logout")
    @Description("User logout was successful")
    public void logout() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.isLoaded();
        loginPage.login("tesztandras@gmail.com", "Hikoki999");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.isLoaded();
        myAccountPage.logout();

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.isLoaded();

    }
}
