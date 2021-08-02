package Tests;

import Pages.DesktopPage;
import Pages.HomePage;
import Pages.NavBar;
import org.junit.jupiter.api.Test;

public class PaginationTest extends BaseTest{

    @Test
    public void pagination() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.isLoaded();

        NavBar navBar = new NavBar(driver);

        DesktopPage desktopPage = navBar.navigateToDesktop();

        desktopPage.isLoaded();
        desktopPage.goToNextPage();

    }
}
