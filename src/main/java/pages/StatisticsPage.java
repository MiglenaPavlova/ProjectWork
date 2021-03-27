package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsPage extends BasePage {

    @FindBy(id="yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id="result-quotes-0")
    private WebElement selectOption;

    @FindBy(xpath ="td[@data-test='DIVIDEND_AND_YIELD-value']")
    ////td[@data-test='DIVIDEND_AND_YIELD-value']
    ////span[text()='Forward Dividend & Yield']/../following-sibling::td
    private WebElement dividendPrice;

    @FindBy(xpath ="//*[@data-test='STATISTICS']")
    private WebElement statisticsTab;

    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td")
    private WebElement priceBook;


    public StatisticsPage(WebDriver driver) {
        super(driver);
    }

    public void checkStatistics(String company, String dividend, String price){
        //executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(username), 4);

        searchInput.sendKeys(company);
        selectOption.click();
        dividendPrice.getText();
        statisticsTab.click();
        priceBook.getText();

    }
}
