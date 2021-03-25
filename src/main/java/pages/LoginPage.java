package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="usernamereg-firstName")
    private WebElement firstNameInput;

    @FindBy(id="usernamereg-lastName")
    private WebElement lastNameInput;

    @FindBy(id="usernamereg-yid")
    private WebElement emailInput;

    @FindBy(id="usernamereg-password")
    private WebElement passwordInput;

    @FindBy(id="usernamereg-phone")
    private WebElement phoneInput;

    @FindBy(id="usernamereg-month")
    private WebElement monthInput;

    @FindBy(id="usernamereg-day")
    private WebElement dayInput;

    @FindBy(id="usernamereg-year")
    private WebElement yearInput;

    @FindBy(id="reg-submit-button")
    private WebElement submitButton;

       //constructor създава всички елементи

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String firstName, String lastName, String email, String password, String phoneNumber,
                      String birthMont, String day, String year){
        //executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(username), 4);

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        phoneInput.sendKeys(phoneNumber);
        monthInput.sendKeys(birthMont);
        dayInput.sendKeys(day);
        yearInput.sendKeys(year);
        submitButton.click();

    }

}
