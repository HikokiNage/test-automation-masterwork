package Tests;

import Pages.*;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Change user Data")
public class ChangePhoneNumberTest extends BaseTest{

    Faker faker = new Faker();
    String phoneNumber = faker.phoneNumber().phoneNumber();

    @Test
    @DisplayName("Change password")
    @Description("The user change the phone number.")
    public void changePhoneNumber() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.login("tesztandras@gmail.com", "Teszt123");
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        myAccountPage.isLoaded();

        EditAccount editAccount = myAccountPage.navigateToEditAccount();
        editAccount.isLoaded();
        editAccount.changePhoneNumber(phoneNumber);

        assertTrue(myAccountPage.successMessageDisplay());
    }
}
