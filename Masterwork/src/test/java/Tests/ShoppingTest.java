package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Add to cart")
public class ShoppingTest extends BaseTest{

    HomePage homePage;
    DesktopPage desktopPage;
    NavBar navBar;

    @BeforeEach
    public void openPage() {
        homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        navBar = new NavBar(driver);
        desktopPage = navBar.navigateToDesktop();
        desktopPage.isLoaded();

    }

    @Test
    @DisplayName("Product add to cart")
    @Description("A felhasználó egy terméket helyez a kosárba.")
    public void addToChart() throws InterruptedException {


        WebElement product = driver.findElement
                (By.xpath("//*[@id=\"content\"]/div[4]/div[13]/div/div[2]/div[2]/button[1]"));

        js.executeScript("arguments[0].scrollIntoView(true);", product);
        product.click();

        js.executeScript("arguments[0].scrollIntoView(true);", homePage.getProductInCart());

        Thread.sleep(1000);

        assertEquals("1 item(s) - $1,500.00", homePage.getProductInCart().getText());
    }

    @Test
    @DisplayName("Remove a product fom the cart")
    @Description("A felhasználó eltávolít egy terméket a kosárból.")
    public void removeFromCart() throws InterruptedException {
        homePage.getProductInCart().click();
        homePage.getRemove().click();

        Thread.sleep(1000);

        assertEquals("0 item(s) - $0.00", homePage.getProductInCart().getText());
    }
}
