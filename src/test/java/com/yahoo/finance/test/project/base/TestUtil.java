package com.yahoo.finance.test.project.base;

import driver.DriverOpenBrowser;
import org.openqa.selenium.WebDriver;
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
/*
    @BeforeSuite
    public void readConfigProperties(){
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties"))
        {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitlyWait"));
            browser = config.getProperty("browser");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

 */

    @BeforeMethod
    public void setUp(){
        readParametersFromFile();
        setupBrowserDriver();
        loadUrl();
    }

    private void loadUrl(){
        driver.get(url);
    }

    private void readParametersFromFile(){
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties"))
        {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitlyWait"));
            browser = config.getProperty("browser");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void  setupBrowserDriver() {
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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
