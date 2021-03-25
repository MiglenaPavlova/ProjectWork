package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsPage extends BasePage {

    @FindBy(id="yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id="result-quotes-0")
    private WebElement selectOption;

    @FindBy(xpath ="//*[@data-test='STATISTICS']")
    private WebElement statisticsTab;


    public StatisticsPage(WebDriver driver) {
        super(driver);
    }

    public void checkStatistics(String company){
        //executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(username), 4);

        searchInput.sendKeys(company);
        selectOption.click();
        statisticsTab.click();

    }
}
