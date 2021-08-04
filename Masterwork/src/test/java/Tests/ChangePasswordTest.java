package Tests;

import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Change user Data")
public class ChangePasswordTest extends BaseTest{

    @Test
    @DisplayName("Change password")
    @Description("A felhasználó megváltoztatja a jelszavát.")
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
