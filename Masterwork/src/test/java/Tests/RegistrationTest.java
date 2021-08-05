package Tests;


import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.RegisterPage;
import Pages.SuccessRegisterPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Registration")
public class RegistrationTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phoneNUmber = faker.phoneNumber().phoneNumber();



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
                firstName, lastName,
                firstName + lastName + "@gmail.com", phoneNUmber,
                "Teszt123", "Teszt123");

        assertTrue(registerPage.privacyAlertDisplay());
    }

    @Test
    @DisplayName("Successful registration")
    @Description("The registration was successful.")
    public void successfulRegistration() {
        registerPage.successfulRegistration(
                firstName, lastName,
                firstName + lastName + "@gmail.com", phoneNUmber,
                "Teszt123", "Teszt123");

        SuccessRegisterPage successRegisterPage = new SuccessRegisterPage(driver);
        successRegisterPage.isLoaded();

        successRegisterPage.getContinueButton().click();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.isLoaded();
        myAccountPage.logout();
    }
}



