package com.yahoo.finance.test.project.base;

import driver.DriverOpenBrowser;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    public WebDriver driver;
    public String url;
    public int implicitWait;
    private String browser;

    //@BeforeSuite
    @BeforeMethod
    public void setUp() {
        readParametersFromFile();
        setupBrowserDriver();
        loadUrl();
        checkCookiesPopup();
    }

    private void loadUrl() {
        driver.get(url);
    }

    private void readParametersFromFile() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitlyWait"));
            browser = config.getProperty("browser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupBrowserDriver() {
        switch (browser) {
            case "firefox":
                driver = DriverOpenBrowser.getFirefoxDriver(implicitWait);
                break;
            case "chrome":
                driver = DriverOpenBrowser.getChromeDriver(implicitWait);
                break;
            default:
                System.out.println("Browser is not correct");
        }
    }

    private void checkCookiesPopup() {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement agreeButton = driver.findElement(By.cssSelector("[value=agree]"));
            js.executeScript("arguments[0].scrollIntoView();", agreeButton);
            agreeButton.click();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
