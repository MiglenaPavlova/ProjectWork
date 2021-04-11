package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "usernamereg-firstName")
    private WebElement firstNameInput;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastNameInput;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailInput;

    @FindBy(id = "usernamereg-password")
    private WebElement passwordInput;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneInput;

    @FindBy(id = "usernamereg-month")
    private WebElement monthInput;

    @FindBy(id = "usernamereg-day")
    private WebElement dayInput;

    @FindBy(id = "usernamereg-year")
    private WebElement yearInput;

    @FindBy(id = "reg-submit-button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void enterBirthMonth(String birthMont) {
        monthInput.sendKeys(birthMont);
    }

    public void enterDay(String day) {
        dayInput.sendKeys(day);
    }

    public void enterYear(String year) {
        yearInput.sendKeys(year);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


    /*public void login(String lastName, String email, String password, String phoneNumber,
                      String birthMont, String day, String year) {

        //firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        phoneInput.sendKeys(phoneNumber);
        monthInput.sendKeys(birthMont);
        dayInput.sendKeys(day);
        yearInput.sendKeys(year);
        submitButton.click();

    }

     */

}
