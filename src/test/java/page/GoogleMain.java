package page;

import config.TestConfig;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleMain{
    private static final TestConfig config = new TestConfig();

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(xpath = "//cite[@role=\"text\"]")
    private List<WebElement> searchLinks;

    public GoogleMain(WebDriver driver) {
        driver.get(config.getGoogleMainUrl());
        PageFactory.initElements(driver, this);
    }

    public void search(String text){
        searchInput.sendKeys(text);
        searchBtn.click();
    }

    public void checkSearch(String text){
        Assert.assertEquals(text, searchInput.getAttribute("value"));
    }

    public void linkIsPresent(String text){
        Assert.assertTrue(searchLinks.stream().anyMatch( x -> x.getText().contains(text)));
    }
}
