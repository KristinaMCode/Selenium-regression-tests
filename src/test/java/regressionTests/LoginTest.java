package regressionTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testLoginPageTitle() {

        driver.get("https://example.com");
        String title = driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertEquals(title, "Example Domain");
        System.out.println("Click on MORE INFO");
        driver.findElement(By.xpath("//a[text()='More information...']")).click();
        Assert.assertEquals(title, "Example Domain");
        System.out.println("New page opened");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

