package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ErrorMessages extends BasePage {

    private static final String ID_lINK_EMAIL_ERROR = "reg-error-yid";
    private static final String ID_lINK_BIRTHDATE_ERROR = "reg-error-birthDate";


    @FindBy(id = "reg-error-yid")
    private WebElement elementEmailError;

    @FindBy(id = "reg-error-password")
    private WebElement elementPasswordError;

    @FindBy(id = "reg-error-phone")
    private WebElement elementPhoneError;

    @FindBy(id = "reg-error-birthDate")
    private WebElement elementBirthDateError;


    public String emailErroroMessage;
    public String passwordErroroMessage;
    public String phoneErrorMessage;
    public String birthDayErroroMessage;


    public ErrorMessages(WebDriver driver) {
        super(driver);
    }

    public String getEmailErrorMessage() {
        return emailErroroMessage = elementEmailError.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErroroMessage = elementPasswordError.getText();
    }

    public String getPhoneErrorMessage() {
        return phoneErrorMessage = elementPhoneError.getText();
    }

    public String getBirthDayErrorMessage() {
        return birthDayErroroMessage = elementBirthDateError.getText();
    }

    public void waitForErrorMessage(int implicitWait) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_lINK_BIRTHDATE_ERROR)));
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }


}
