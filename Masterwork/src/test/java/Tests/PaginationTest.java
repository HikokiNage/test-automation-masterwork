package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Pagination")
public class PaginationTest extends BaseTest{

    @Test
    @DisplayName("Go to next page")
    @Description("The user flips through the next page.")
    public void pagination() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        NavBar navBar = new NavBar(driver);

        DesktopPage desktopPage = navBar.navigateToDesktop();

        desktopPage.isLoaded();
        desktopPage.goToNextPage();

        assertEquals("Showing 16 to 16 of 16 (2 Pages)",
                desktopPage.getShowingProductOnPagesString());
    }
}
