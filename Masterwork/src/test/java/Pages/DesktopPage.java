package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DesktopPage extends HomePage{

    @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[1]/ul/li[3]/a")
    WebElement nextPage;

    @FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[2]")
    WebElement showingPages;

    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Desktops"));
    }

    public void goToNextPage() {
        js.executeScript("arguments[0].scrollIntoView(true);", nextPage);
        nextPage.click();

    }

    public String getShowingProductOnPagesString() {
        return showingPages.getText();
    }



}
