package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Listing")
public class ListingTest extends BaseTest{

    @Test
    @DisplayName("Sort A-Z")
    @Description("A termékek rendezése A-tól Z-ig.")
    public void shouldListToA_Z() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        NavBar navBar = new NavBar(driver);

        DesktopPage desktopPage =navBar.navigateToDesktop();
        desktopPage.isLoaded();

        driver.findElement(By.id("input-sort")).click();
        driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[2]")).click();


        List<WebElement> products = new ArrayList<>(driver.findElements(By.tagName("h4")));

        assertEquals("Acer Predator Orion 3000", products.get(0).getText());
    }
}
