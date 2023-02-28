package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompletePage extends BasePage{
    @FindBy(className = "complete-header")
    WebElement completeText;

    public CompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void succesfulCheckoutComplete(){
        completeText.getText();
        Assert.assertEquals(completeText.getText(),"Thank you for your order!");
    }
}
