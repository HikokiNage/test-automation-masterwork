package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import static org.assertj.core.api.Assertions.*;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


@Feature("Send Review")
public class SendReviewTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = "/reviews.csv", numLinesToSkip = 1)
    @DisplayName("Sending Review")
    @Description("The user send a review and rating the product.")
    public void sendReview(String yourName, String yourReview, String rating) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        NavBar navBar = new NavBar(driver);
        DesktopPage desktopPage = navBar.navigateToDesktop();
        desktopPage.isLoaded();

        driver.findElement(By.linkText("Canon EOS 5D")).click();
        driver.findElement(By.linkText("Reviews (0)")).click();

        driver.findElement(By.id("input-name")).sendKeys(yourName);
        driver.findElement(By.id("input-review")).sendKeys(yourReview);

        List<WebElement> ratingButton = new ArrayList<>(driver.findElements(By.name("rating")));

        for (WebElement ratings : ratingButton) {
            if (ratings.getAttribute("value").equals(rating)) {
                ratings.click();
            }
        }

        driver.findElement(By.id("button-review")).click();

        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[2]"));

        assertThat(successMessage.isDisplayed()).isTrue();
    }
}
