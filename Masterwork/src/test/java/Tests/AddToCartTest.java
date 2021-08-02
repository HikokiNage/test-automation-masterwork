package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddToCartTest extends BaseTest{

    @Test
    public void addToCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        NavBar navBar = new NavBar(driver);

        DesktopPage desktopPage = navBar.navigateToDesktop();

        homePage.addToChart();

        driver.findElement(By.id("cart-total")).click();

        Thread.sleep(9000);
    }
}
