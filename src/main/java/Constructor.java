import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestClass {
    public TestClass() {
        System.out.println("in constructor");
    }

    public TestClass(String a) {
        System.out.println("constructor with argument");
    }
}

public class Constructor {

    public static void main(String[] args) {
        TestClass testClass = new TestClass("abc");

    }

    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver, WebDriverWait wait){
        this. driver = driver;
        this.wait = wait;
    }
}
