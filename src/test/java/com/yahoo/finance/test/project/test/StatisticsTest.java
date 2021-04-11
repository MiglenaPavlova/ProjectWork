package com.yahoo.finance.test.project.test;

import com.opencsv.exceptions.CsvException;
import com.yahoo.finance.test.project.base.TestUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DividendPage;
import utils.CsvReader;

import java.io.IOException;

public class StatisticsTest extends TestUtil {

    @DataProvider(name = "company-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company.csv");
    }

    @Test(dataProvider = "company-data-file")
    public void compareStatistics(String company, String dividend, String price) {

        DividendPage dividendPage = new DividendPage(driver);
        dividendPage.enterCompanyInSearchInput(company);
        dividendPage.waitForResult(6);
        dividendPage.clickTheResult();
        dividendPage.getDividend();
        dividendPage.openStatisticsTab();
        dividendPage.getPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dividendPage.dividendCheck, dividend);
        softAssert.assertEquals(dividendPage.priceCheck, price);
        softAssert.assertAll();

    }
}
