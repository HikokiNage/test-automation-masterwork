package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends HomePage{

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
    WebElement desktops;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
    WebElement showAllDesktops;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
    WebElement laptopsEndNotebooks;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
    WebElement showAllLaptopsEndNotebooks;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[3]/a")
    WebElement components;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[3]/div/a")
    WebElement showAllComponents;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[4]/a")
    WebElement tablets;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[5]/a")
    WebElement software;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[6]/a")
    WebElement phonesAndPDAs;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[7]/a")
    WebElement cameras;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[8]/div/a")
    WebElement showAllCameras;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[8]/a")
    WebElement mp3Players;

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public DesktopPage navigateToDesktop() {
        desktops.click();
        showAllDesktops.click();

        return new DesktopPage(driver);
    }
}