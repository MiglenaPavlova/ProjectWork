package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DividendPage extends BasePage {

    @FindBy(id="yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id="result-quotes-0")
    private WebElement selectOption;


    @FindBy(xpath ="//*[@data-test='STATISTICS']")
    private WebElement statisticsTab;


    public String dividendCheck;
    public String priceCheck;
    private static final String XPATH_lINK_DIVIDEND = "//td[@data-test='DIVIDEND_AND_YIELD-value']";
    private static final String XPATH_lINK_PRICE_BOOK = "//span[text()='Price/Book']/../following-sibling::td";

    public DividendPage(WebDriver driver) {
        super(driver);
    }

    public void checkStatistics(String company){
        searchInput.sendKeys(company);
        selectOption.click();
        waitForElement(XPATH_lINK_DIVIDEND, 6);
        dividendCheck = driver.findElement(By.xpath(XPATH_lINK_DIVIDEND)).getText();
        statisticsTab.click();
        waitForElement(XPATH_lINK_PRICE_BOOK, 6);
        priceCheck= driver.findElement(By.xpath(XPATH_lINK_PRICE_BOOK)).getText();


    }

    public void waitForElement(String xpathString, int implicitWait ){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathString)));
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

}
