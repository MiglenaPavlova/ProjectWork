package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DividendPage extends BasePage {

    public String dividendToCheck;
    public String priceToCheck;
    public WebElement textValueOfTheElement;
    //private static final String XPATH_lINK_DIVIDEND = "//td[@data-test='DIVIDEND_AND_YIELD-value']";
    //private static final String XPATH_lINK_PRICE_BOOK = "//span[text()='Price/Book']/../following-sibling::td";

    @FindBy(id = "yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id = "result-quotes-0")
    private WebElement selectOption;


    @FindBy(xpath = "//*[@data-test='STATISTICS']")
    private WebElement statisticsTab;


    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    public WebElement dividendField;

    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td")
    public WebElement priceBookField;

    public DividendPage(WebDriver driver) {
        super(driver);
    }

    public void enterCompanyInSearchInput(String company) {
        searchInput.sendKeys(company);
    }

    public void clickTheResult() {
        waitForElement(15, selectOption);
        selectOption.click();
    }

    public String getDividend() {
        waitForElement(15, dividendField);
        return dividendField.getText();

    }

    public void openStatisticsTab() {
        statisticsTab.click();
    }

    public String getPrice() {
        waitForElement(15, priceBookField);
        return priceBookField.getText();
    }


}
