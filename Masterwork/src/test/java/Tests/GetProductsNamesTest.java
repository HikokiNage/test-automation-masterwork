package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Feature("Save data")
public class GetProductsNamesTest extends BaseTest{

    @Test
    @DisplayName("Save products names")
    @Description("Lementjök egy fájlba az adott oldalon található termékek neveit")
    public void getAllProductsNames() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        NavBar navBar = new NavBar(driver);
        DesktopPage desktopPage = navBar.navigateToDesktop();
        desktopPage.isLoaded();

        List<WebElement> products = new ArrayList<>(driver.findElements(By.tagName("h4")));
        List<String> productsNames = new ArrayList<>();

        for (WebElement product : products) {
            productsNames.add(product.getText());
        }

        Path path = Paths.get("src\\test\\resources\\product-names.txt");
        Files.write(path, productsNames);

        List<String> actual = new ArrayList<>(Files.readAllLines(path));

        Assertions.assertEquals(productsNames, actual);
    }
}
