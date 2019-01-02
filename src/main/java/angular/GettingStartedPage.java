package angular;

import helper.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.assertj.core.api.Assertions.assertThat;

public class GettingStartedPage extends PageObject {
    public GettingStartedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#getting-started")
    WebElement title;

    public void checkTitle(String expectedTitle){
        assertThat(title.getText()).as("Title in 'Getting Started page' should be equal to " + expectedTitle).isEqualTo(expectedTitle);
    }
}
