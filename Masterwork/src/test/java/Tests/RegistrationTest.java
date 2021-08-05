package Tests;


import Pages.HomePage;
import Pages.RegisterPage;
import Pages.SuccessRegisterPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Registration")
public class RegistrationTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeEach
    public void goToRegisterPage() {
        homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        registerPage = homePage.navigateToRegisterPage();

        registerPage.isLoaded();

    }

    @Test
    @DisplayName("Read Privacy Policy")
    @Description("The read Privacy Policy.")
    public void readPrivacyPolicy() {
        registerPage.readPrivacyPolicy();
    }

    @Test
    @DisplayName("Unsuccessful registration")
    @Description("The user don't accept Privacy Policy.")
    public void unsuccessfulRegistration() {
        registerPage.unsuccessfulRegistration(
                "Jone", "Doe",
                "jonedoe@gmail.com", "+36201234567",
                "Jondoe123", "Jondoe123");

        assertTrue(registerPage.privacyAlertDisplay());
    }

    @Test
    @DisplayName("Successful registration")
    @Description("The registration was successful.")
    public void successfulRegistration() {
        registerPage.successfulRegistration(
                "Jon", "Doe",
                "jondoe@gmail.com", "+36201234567",
                "Jondoe123", "Jondoe123");

        SuccessRegisterPage successRegisterPage = new SuccessRegisterPage(driver);
        successRegisterPage.isLoaded();

    }
}



