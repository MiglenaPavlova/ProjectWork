package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(int timeOutSeconds, WebElement waitFor, int implicitWait) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(ExpectedConditions.visibilityOf(waitFor));
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }


}
