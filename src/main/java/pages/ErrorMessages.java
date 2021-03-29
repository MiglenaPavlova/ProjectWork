package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorMessages extends BasePage{

    public String emailErroroMessage = driver.findElement(By.id("reg-error-yid")).getText();
    public String passwordErroroMessage = driver.findElement(By.id("reg-error-password")).getText();
    public String phoneErrorMessage = driver.findElement(By.id("reg-error-phone")).getText();
    public String bithDayErroroMessage = driver.findElement(By.id("reg-error-birthDate")).getText();


    public ErrorMessages(WebDriver driver) {
        super(driver);
    }

}
