package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    @BeforeAll
    public void setup() throws IOException {

        Properties properties = new Properties();
        InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
        properties.load(propertiesStream);

        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }

        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        js = ((JavascriptExecutor) driver);

    }

    @AfterAll
    public void teardown() {
        driver.quit();
    }


}
