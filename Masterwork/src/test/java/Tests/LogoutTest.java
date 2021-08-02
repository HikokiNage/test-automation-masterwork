package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.MyAccountPage;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest{



    @Test
    public void logout() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.isLoaded();
        loginPage.login("tesztandras@gmail.com", "Teszt123");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.isLoaded();
        myAccountPage.logout();

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.isLoaded();

    }
}
