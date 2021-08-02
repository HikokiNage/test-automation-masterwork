package Tests;


import Pages.HomePage;
import Pages.RegisterPage;
import Pages.SuccessRegisterPage;
import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegistrationTest extends BaseTest {

    @Test
    public void unsuccessfulRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        RegisterPage registerPage = homePage.navigateToRegisterPage();

        registerPage.isLoaded();

        registerPage.unsuccessfulRegistration(
                "Gipsz", "Karton",
                "gipszkarton@gmail.com", "+36201234567",
                "Teszt123", "Teszt123");

        assertTrue(registerPage.privacyAlertDisplay());
    }

    @Test
    public void successfulRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        RegisterPage registerPage = homePage.navigateToRegisterPage();

        registerPage.isLoaded();

        registerPage.successfulRegistration(
                "Víz", "Elek",
                "vizelek@gmail.com", "+36203456789",
                "Teszt123", "Teszt123");

        SuccessRegisterPage successRegisterPage = new SuccessRegisterPage(driver);
        successRegisterPage.isLoaded();

    }

    @Test
    public void readPrivacyPolicy() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        RegisterPage registerPage = homePage.navigateToRegisterPage();

        registerPage.isLoaded();

        registerPage.readPrivacyPolicy();
    }
}



