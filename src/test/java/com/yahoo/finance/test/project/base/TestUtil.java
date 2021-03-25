package com.yahoo.finance.test.project.base;

import driver.DriverOpenBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    public WebDriver driver;
    public String url;
    private int implicitWait;
    private String browser;

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

    @BeforeTest
    public void setUp(){
        setupBrowserDriver();
        loadUrl();
    }

    private void loadUrl(){
        driver.get(url);
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

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
