package github.com.agatagolonka.amazontest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeletingItemFromCart {
    public static final String CHROME_DRIVER_PATH = "D:\\chromedriver.exe";
    public static final String AMAZON_HOMEPAGE = "https:\\amazon.com";
    private static final String CART_EMPTY = "Your Amazon Cart is empty";
    WebDriver driver;

    @BeforeEach
    void startPage(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AMAZON_HOMEPAGE);

        //add-to-cart
        WebElement element;
        element = driver.findElement(By.xpath("html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        element.sendKeys("Witcher 3");
        element.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();

        String str = driver.findElement(By.xpath("//span[text()=\"Witcher 3: Wild Hunt Complete Edition - PlayStation 4 Complete Edition\"]")).getText();
        WebElement item = driver.findElement(By.xpath("//span[text()=\"Witcher 3: Wild Hunt Complete Edition - PlayStation 4 Complete Edition\"]"));
        item.click();

        WebElement addToCart= driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();


    }


    @Test
    public void testDeletingItemFromCart() {
        driver.get("https://www.amazon.com/gp/cart/view.html/ref=lh_cart");
        driver.manage().timeouts().implicitlyWait(4 , TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.cssSelector("input[value='Delete']"));
         element.click();

        String strCart = driver.findElement(By.xpath("html/body/div[1]/div[4]/div[1]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]/div[1]/h2")).getText();
        Assert.assertEquals(strCart,CART_EMPTY);
    }



        @AfterClass
    public void quitBrowser() {

        driver.quit();
    }

    private class Li {
    }
}
