package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import page.GoogleMain;

import java.time.Duration;

public class GoogleStepdefs {
    protected WebDriver driver;

    protected GoogleMain google;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver = driver;
    }

    @Given("open Google main page")
    public void openGoogleMainPage() {
        google = new GoogleMain(driver);
    }

    @When("search {string}")
    public void enterInSearchString(String text) { google.search(text); }

    @Then("{string} word presents on landing page")
    public void wordPresentsOnLandingPage(String text) {
        google.checkSearch(text);
    }

    @And("{string} link is present")
    public void linkIsPresent(String text) { google.linkIsPresent(text); }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
