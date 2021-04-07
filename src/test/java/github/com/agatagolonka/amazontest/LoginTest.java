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

class LoginTest {
    public static final String CHROME_DRIVER_PATH = "D:\\chromedriver.exe";
    public static final String AMAZON_HOMEPAGE = "https:\\amazon.com";
    WebDriver driver;

    @BeforeEach
    void startPage(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AMAZON_HOMEPAGE);
    }

    @Test
    void testLogin() {

        WebElement element = driver.findElement(By.xpath("html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/div"));
        element.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[1]/input[1]"));
        login.sendKeys("annanowaktestuser@gmail.com");
        WebElement button = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/form/div/div/div/div[2]/span/span/input"));
        button.click();
        WebElement passwd = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div/form/div/div[1]/input"));
        passwd.sendKeys("annanowaktestuser");
        WebElement button2 = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div/form/div/div[2]/span/span/input"));
        button2.click();
        String str = driver.findElement(By.xpath("html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/div/span")).getText();
        Assert.assertTrue(str.contains("Hello, Anna"));

    }

    @AfterClass
    void quitBrowser() {

        driver.quit();
    }
}
