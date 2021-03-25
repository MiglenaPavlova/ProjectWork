package com.yahoo.finance.test.project.test;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.test.project.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MainPage;
import utils.CsvReader;

import java.io.IOException;

public class LoginTest extends TestUtil {

    @DataProvider(name = "login-data-file")
    public static  Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/negative-login-data.csv");
    }


    @Test(dataProvider = "login-data-file")
    public void executeSimpleTest(String firstName,String lastName, String email, String password, String phoneNumber,
                                  String birthMont, String day, String year) {

        try
        {
           // boolean agreeForm = driver.findElement(By.className("con-wizard")).isDisplayed();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement agreeButton = driver.findElement(By.cssSelector("[value=agree]"));
            js.executeScript("arguments[0].scrollIntoView();", agreeButton);
            agreeButton.click();

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

            //Reporter.log("ste2");
            MainPage mainPage = new MainPage(driver);
            mainPage.signIn();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(firstName,lastName, email, password, phoneNumber, birthMont, day, year);

            //reg-error-password
            String emailErroroMessage = driver.findElement(By.id("reg-error-yid")).getText();
            String passwordErroroMessage = driver.findElement(By.id("reg-error-password")).getText();
            String phoneErrorMessage = driver.findElement(By.id("reg-error-phone")).getText();
            String bithDayErroroMessage = driver.findElement(By.id("reg-error-birthDate")).getText();

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(emailErroroMessage, "This email address is not available for sign up, try something else");
            softAssert.assertEquals(passwordErroroMessage, "Your password isn’t strong enough, try making it longer.");
            softAssert.assertEquals(phoneErrorMessage, "That doesn’t look right, please re-enter your phone number.");
            softAssert.assertEquals(bithDayErroroMessage, "That doesn’t look right, please re-enter your birthday.");

            softAssert.assertAll();
            driver.navigate().to(url);


    }


}
