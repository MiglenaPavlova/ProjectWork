package com.yahoo.finance.test.project.test;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.test.project.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
            // boolean agreeForm = driver.findElement(By.className("con-wizard")).isDisplayed();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement agreeButton = driver.findElement(By.cssSelector("[value=agree]"));
            js.executeScript("arguments[0].scrollIntoView();", agreeButton);
            agreeButton.click();

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

        StatisticsPage statisticsPage = new StatisticsPage(driver);
        statisticsPage.checkStatistics(company, dividend, price);

    }
}
