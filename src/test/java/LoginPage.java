import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    List<WebElement> userNameList;

    @FindBy(className = ".cart_list")
    List<WebElement> cartList;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameField() {
        return this.usernameField;
    }

    public WebElement getPasswordField() {
        return this.passwordField;
    }

    public WebElement getLoginButton() {
        return this.loginButton;
    }

    public void clickLoginButton() {
        click(this.loginButton);
    }

    public int getListSize() {
        return userNameList.size();
    }

    public WebElement getLastElement() {
        return cartList.get(cartList.size() - 1);
    }
}
