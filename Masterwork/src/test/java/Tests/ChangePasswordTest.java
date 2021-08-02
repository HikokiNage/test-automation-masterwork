package Tests;

import Pages.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangePasswordTest extends BaseTest{

    @Test
    public void changePassword() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.login("tesztandras@gmail.com", "Teszt123");
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        myAccountPage.isLoaded();

        PasswordPage passwordPage = myAccountPage.navigateToPasswordPage();

        passwordPage.changePassword("Hikoki999");

        assertTrue(myAccountPage.successMessageDisplay());

    }
}
