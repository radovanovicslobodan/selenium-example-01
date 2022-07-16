import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasicTest {

    WebDriver driver;
    WebDriverWait wait;

//    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

//    @AfterMethod
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

    @Test
    public void solveGameSelenium() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://zzzscore.com/1to50/en/");

        long startTime = System.nanoTime();

        for (int i = 1; i <= 50; i++) {
            driver.findElement(By.xpath("//div[text()=" + i + "]")).click();
        }

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Total execution time: " + elapsedTime + "ns");

        WebElement result = driver.findElement(By.className("resultContent"));
        File file = result.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("result.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAttribute() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://chercher.tech/");
        // clicks the button which has id = 'button'
        String valueAttribute = driver.findElement(By.id("logo")).getAttribute("alt");
        System.out.println("Attribute of value is : "+ valueAttribute);
    }

    @Test
    public void solveGameJsExec() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://zzzscore.com/1to50/en/");

        js.executeAsyncScript("(async () => {\n" +
                "  const getValidBoxes = () => [...document.querySelectorAll(\"#grid > div\")].filter(d => d.style.opacity === '1')\n" +
                "  while (getValidBoxes().length > 0) {\n" +
                "    getValidBoxes().forEach(d => d.dispatchEvent(new Event('tap')))\n" +
                "    await new Promise(res => requestIdleCallback(res))\n" +
                "  }\n" +
                "})()");

        WebElement result = driver.findElement(By.className("resultContent"));
        File file = result.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("result.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
