package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "header-signin-link")
    private WebElement signInButton;

    @FindBy(id = "createacc")
    private WebElement createAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSighInButton() {
        signInButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

}
