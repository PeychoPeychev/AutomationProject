package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilInformationPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement checkOutBtn;
    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public ProfilInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutOverviewPage userInfromation(String firstName, String lastName, String postalCode) {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        checkOutBtn.click();

        return new CheckoutOverviewPage(driver);
    }

    public void unsuccesfulCheckout(){
        errorMessage.getText();
        Assert.assertEquals(errorMessage.getText(),"Error: Last Name is required");
    }
}
