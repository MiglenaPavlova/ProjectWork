package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(id="header-signin-link")
    private WebElement signInButton;

    //signInButton.click();

    @FindBy(id="createacc")
    private WebElement createAccountButton;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(){
        signInButton.click();
        createAccountButton.click();
    }
}
