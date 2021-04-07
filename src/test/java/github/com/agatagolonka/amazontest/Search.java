package github.com.agatagolonka.amazontest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;


class Search {

    public static final String CHROME_DRIVER_PATH = "D:\\chromedriver.exe";
    public static final String AMAZON_HOMEPAGE = "https:\\amazon.com";
    WebDriver driver;

    @BeforeEach
    void startPage() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AMAZON_HOMEPAGE);
    }

    @Test
    void testSearch() {
        WebElement element;
        element = driver.findElement(By.xpath("html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        element.sendKeys("Witcher 3");
        element.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String str = driver.findElement(By.xpath("//span[text()=\"Witcher 3: Wild Hunt Complete Edition - PlayStation 4 Complete Edition\"]")).getText();
        Assert.assertTrue(str.contains("Witcher"));

    }

    @AfterClass
    void quitBrowser() {

        driver.quit();
    }
}
