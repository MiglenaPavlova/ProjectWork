package com.yahoo.finance.test.project.test;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.test.project.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StatisticsPage;
import utils.CsvReader;

import java.io.IOException;

public class StatisticsTest extends TestUtil {

    @DataProvider(name = "company-data-file")
    public static  Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company.csv");
    }


    @Test(dataProvider = "company-data-file")

    public void compareStatistics(String company, String dividend, String price){

        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement agreeButton = driver.findElement(By.cssSelector("[value=agree]"));
            js.executeScript("arguments[0].scrollIntoView();", agreeButton);
            agreeButton.click();

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

        StatisticsPage statisticsPage = new StatisticsPage(driver);
        statisticsPage.checkStatistics(company);
        dividend.toString();
        price.toString();

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement tableDividendValue = driver.findElement(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']"));
        //js.executeScript("arguments[0].scrollIntoView();", tableDividendValue);

        String dividendCheck = driver.findElement(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")).getText();
        //System.out.println(dividendCheck);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dividendCheck, dividend);
        Reporter.log("Amazon dividend check passed");
        WebElement statisticsTab = driver.findElement(By.xpath("//*[@data-test='STATISTICS']"));
        //  //a[@href='/quote/AMZN/key-statistics?p=AMZN']
        statisticsTab.click();

        String priceCheck = driver.findElement(By.xpath("//span[text()='Price/Book']/../following-sibling::td")).getText();
        softAssert.assertEquals(priceCheck, price);
        Reporter.log("Amazon price check passed");

        softAssert.assertAll();


    }
}
