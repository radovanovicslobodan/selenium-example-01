import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasicTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        boolean isLoginButtonDisplayed = wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.id("login-button"))))).isDisplayed();

        wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.id("login-button"))))).click();

        Thread.sleep(1000);

        driver.findElement(By.id("login-button")).click();

        WebElement shoppingCartContainer = driver.findElement(By.id("shopping_cart_container"));

        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".inventory_item_label a"));

//        listOfProducts.get(0).click();

        Assert.assertTrue(shoppingCartContainer.isDisplayed());
        Assert.assertTrue(isLoginButtonDisplayed);

        driver.quit();
    }

    @Test
    public void secondTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
//        loginPage.getLoginButton().click();
        System.out.println(loginPage.getListSize());
        loginPage.clickLoginButton();
    }
}
