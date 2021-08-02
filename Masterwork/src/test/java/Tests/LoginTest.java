package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.NavBar;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void SuccessfulLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.isLoaded();

        loginPage.login("tesztandras@gmail.com", "Teszt123");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.isLoaded();
    }


}
