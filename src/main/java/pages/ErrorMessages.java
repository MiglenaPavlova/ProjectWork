package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorMessages extends BasePage {

    @FindBy(id = "reg-error-yid")
    private WebElement elementEmailError;

    @FindBy(id = "reg-error-password")
    private WebElement elementPasswordError;

    @FindBy(id = "reg-error-phone")
    private WebElement elementPhoneError;

    @FindBy(id = "reg-error-birthDate")
    private WebElement elementBirthDateError;


    public ErrorMessages(WebDriver driver) {
        super(driver);
    }

    public String getEmailErrorMessage() {
        return elementEmailError.getText();
    }

    public String getPasswordErrorMessage() {
        return elementPasswordError.getText();
    }

    public String getPhoneErrorMessage() {
        return elementPhoneError.getText();
    }

    public String getBirthDayErrorMessage() {
        waitForElement(10, elementBirthDateError, 6);
        return elementBirthDateError.getText();
    }

}
