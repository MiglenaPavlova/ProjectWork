package com.yahoo.finance.test.project.test;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.test.project.base.TestUtil;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ErrorMessages;
import pages.HomePage;
import pages.LoginPage;
import utils.CsvReader;

import java.io.IOException;

public class CreateAccountTest extends TestUtil {

    @DataProvider(name = "login-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/negative-login-data.csv");
    }

    @Test(dataProvider = "login-data-file")
    public void createAccountTest(String firstName, String lastName, String email, String password, String phoneNumber,
                                  String birthMont, String day, String year) {

        HomePage homePage = new HomePage(driver);
        homePage.clickSighInButton();
        homePage.clickCreateAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterFirstName(firstName);
        loginPage.enterLastName(lastName);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.enterPhoneNumber(phoneNumber);
        loginPage.enterBirthMonth(birthMont);
        loginPage.enterDay(day);
        loginPage.enterYear(year);
        loginPage.clickSubmitButton();

        ErrorMessages errorMessages = new ErrorMessages(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMessages.getEmailErrorMessage(), "This email address is not available for sign up, try something else");
        Reporter.log("Error message for email is checked. ");
        softAssert.assertEquals(errorMessages.getPasswordErrorMessage(), "Your password isn’t strong enough, try making it longer.");
        Reporter.log("Error message for password is checked. ");
        softAssert.assertEquals(errorMessages.getPhoneErrorMessage(), "That doesn’t look right, please re-enter your phone number.");
        Reporter.log("Error message for phone number is checked. ");
        softAssert.assertEquals(errorMessages.getBirthDayErrorMessage(), "That doesn’t look right, please re-enter your birthday.");
        Reporter.log("Error message for the date is checked. ");

        softAssert.assertAll();

    }

}
