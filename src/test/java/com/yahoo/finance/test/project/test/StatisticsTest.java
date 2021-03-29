package com.yahoo.finance.test.project.test;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.test.project.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StatisticsPage;
import utils.CsvReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

        //waits for element "Forward Dividend & Yield" to be present
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")));
        String dividendCheck = driver.findElement(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")).getText();
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        //System.out.println(dividendCheck);
        //compares the Dividend
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dividendCheck, dividend);


        WebElement statisticsTab = driver.findElement(By.xpath("//*[@data-test='STATISTICS']"));
        statisticsTab.click();

        ////waits for element "Price/Book (mrq)" to be present
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Price/Book']/../following-sibling::td")));
        String priceCheck = driver.findElement(By.xpath("//span[text()='Price/Book']/../following-sibling::td")).getText();
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        //compares the Price
        softAssert.assertEquals(priceCheck, price);

        softAssert.assertAll();

    }
}
