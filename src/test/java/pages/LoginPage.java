package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductPage login(String userName, String password){
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductPage(driver);
    }
    public void unsuccesfulMessage(){
        errorMessage.getText();
        Assert.assertEquals(errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

}
