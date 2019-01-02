package angular;

import helper.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AngularMainPage extends PageObject {
    @FindBy(css = ".button.hero-cta")
    private WebElement startedButton;

    @FindBy(css = "input[type='search']")
    private WebElement searchField;

    @FindBy(css = ".search-results .search-area.ng-star-inserted li")
    private List<WebElement> searchResults;

    public AngularMainPage(WebDriver driver) {
        super(driver);
    }

    public AngularMainPage openMainPage() {
        driver.get("https://angular.io");
        return this;
    }

    public void clickOnStartedButton() {
        startedButton.click();
    }

    public AngularMainPage search(String request) {
        searchField.sendKeys(request);
        return this;
    }

    public void checkCountSearchResult(int expectedSize) {
        int size = searchResults.size();
        assertThat(size).as("Size should be less then " + expectedSize).isLessThan(expectedSize);
    }

}
