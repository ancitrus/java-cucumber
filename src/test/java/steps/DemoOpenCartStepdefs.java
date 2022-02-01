package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.DemoOpenCartIndexPage;
import service.MyWebDriver;

public class DemoOpenCartStepdefs{

    protected DemoOpenCartIndexPage page;
    protected MyWebDriver driver;

    @Before
    public void setUp() {
        this.driver = new MyWebDriver();
    }

    @After
    public void tearDown() {
        this.driver.tearDown();
    }

    @Given("open index page")
    public void openIndexPage() {
        page = new DemoOpenCartIndexPage(this.driver);
    }

    @When("click top menu Account - Registration")
    public void clickTopMenuAccountRegistration() {
        page.clickAccReg();
    }

    @Then("current url is {string}")
    public void currentUrlIs(String url) {
        Assert.assertEquals(url, this.driver.getCurrentUrl());
    }


    @When("choose {string} in language selector")
    public void chooseInLanguageSelector(String lang) {
        page.changeLang(lang);
    }

    @Then("current language is {string}")
    public void currentLanguageIs(String lang) {
        page.initElements(this.driver);
        Assert.assertEquals(lang, page.getCurLang());
    }











    @Given("open {string}")
    public void open(String url) {

    }

    @And("Subscription options radiobutton presents")
    public void subscriptionOptionsRadiobuttonPresents() {
    }

    @And("Privacy policy checkbox presents")
    public void privacyPolicyCheckboxPresents() {
    }

    @When("user account info is set")
    public void userAccountInfoIsSet() {
    }

    @And("Privacy policy is accepted")
    public void privacyPolicyIsAccepted() {
    }

    @And("{string} button is clicked")
    public void buttonIsClicked(String arg0) {
    }

    @Then("{string} is on landing page")
    public void isOnLandingPage(String arg0) {
    }


    @When("topsearch {string}")
    public void topsearch(String text) {
        page.headerSearch("text");
    }

    @Then("search is done")
    public void searchIsDone() {
    }

    @When("choose {string} in currency selector")
    public void chooseInCurrencySelector(String currency) {
        page.selectCurrency(currency);
    }

    @Then("current currency is {string}")
    public void currentCurrencyIs(String currency) {
        Assert.assertEquals(currency, page.getCurCurrency());
    }

    @Then("top menu consists of: {string}")
    public void topMenuConsistsOf(String menuItems) {
        Assert.assertEquals(menuItems, page.menuItems());
    }
}
