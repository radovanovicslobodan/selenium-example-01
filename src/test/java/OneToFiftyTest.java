import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OneToFiftyTest {

    @Test
    public void solveGameSelenium() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://zzzscore.com/1to50/en/");

        for (int i = 1; i <= 50; i++) {
            driver.findElement(By.xpath("//div[text()=" + i + "]")).click();
        }
    }
}
