package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DividendPage extends BasePage {

    public String dividendCheck;
    public String priceCheck;
    public WebElement textValueOfTheElement;
    private static final String XPATH_lINK_DIVIDEND = "//td[@data-test='DIVIDEND_AND_YIELD-value']";
    private static final String XPATH_lINK_PRICE_BOOK = "//span[text()='Price/Book']/../following-sibling::td";

    @FindBy(id = "yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id = "result-quotes-0")
    private WebElement selectOption;


    @FindBy(xpath = "//*[@data-test='STATISTICS']")
    private WebElement statisticsTab;


    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    public WebElement dividendField;

    public DividendPage(WebDriver driver) {
        super(driver);
    }

    public void enterCompanyInSearchInput(String company) {
        searchInput.sendKeys(company);
    }

    public void clickTheResult() {
        selectOption.click();
    }

    public String getDividend() {
        waitForElement(XPATH_lINK_DIVIDEND, 6);
        dividendCheck = driver.findElement(By.xpath(XPATH_lINK_DIVIDEND)).getText();
        return dividendCheck;
    }

    public void openStatisticsTab() {
        statisticsTab.click();
    }

    public String getPrice() {
        waitForElement(XPATH_lINK_PRICE_BOOK, 6);
        priceCheck = driver.findElement(By.xpath(XPATH_lINK_PRICE_BOOK)).getText();
        return priceCheck;
    }

    public void waitForResult(int implicitWait) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-quotes-0")));
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

}
