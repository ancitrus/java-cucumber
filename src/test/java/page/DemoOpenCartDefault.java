package page;

import config.DemoOpenCartConfig;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.MyWebDriver;

import java.util.Objects;


public class DemoOpenCartDefault extends PageFactory {

    protected static final DemoOpenCartConfig config = new DemoOpenCartConfig();

    //    HEADER
//    HEADER: NAVIGATION
    @FindBy(xpath = "//nav[@id='top']")
    protected WebElement navigationTop;


    //  HEADER: CHANGE CURRENCY
    @FindBy(xpath = "//form[@id='form-currency']//button[@data-toggle]")
    protected WebElement currCaret;

    @FindBy(xpath = "//form[@id='form-currency']//button[@name='EUR']")
    protected WebElement currEUR;

    @FindBy(xpath = "//form[@id='form-currency']//button[@name='GBP']")
    protected WebElement currGBP;

    @FindBy(xpath = "//form[@id='form-currency']//button[@name='USD']")
    protected WebElement currUSD;

    @FindBy(xpath = "//form[@id='form-currency']//button[@name='RUB']")
    protected WebElement currRUB;



    //  HEADER: CHANGE LANGUAGE
    @FindBy(xpath = "//form[@id='form-language']//button[@data-toggle]")
    protected WebElement langCaret;

    @FindBy(xpath = "//form[@id='form-language']//button[@name='en-gb']")
    protected WebElement langEn;

    @FindBy(xpath = "//form[@id='form-language']//button[@name='ru-ru']")
    protected WebElement langRu;

    @FindBy(xpath = "//form[@id='form-language']//button[@data-toggle]/img")
    protected WebElement curLang;

    @FindBy(className = "caret")
    protected WebElement accCaret;

    @FindBy(xpath = "//a[contains(@href, 'register')]")
    protected WebElement registerLink;

    //    HEADER: SEARCH
    @FindBy(xpath = "//div[@id='search']//input")
    protected WebElement headerSearchInput;

    @FindBy(xpath = "//div[@id='search']//button/i[contains(@class, 'fa-search')]")
    protected WebElement headerSearchBtn;

    //    HEADER: TOP MENU
    @FindBy(xpath = "//ul[@class='nav navbar-nav']")
    protected WebElement topMenuUl;




//FOOTER

//    FOOTER: COPYRIGHT
    @FindBy(xpath = "//footer//p[contains(., '©')]")
    protected WebElement footerCopyright;

    public DemoOpenCartDefault(@NotNull MyWebDriver driver, String url) {
        driver.getUrl(url);
        initElements(driver);
    }

    public void initElements(@NotNull MyWebDriver driver){
        driver.initElements(this);
    }

    public void headerSearch(String text){
        headerSearchInput.sendKeys(text);
        headerSearchBtn.click();
    }

    public void clickAccReg() {
        accCaret.click();
        registerLink.click();
    }

    public void changeLang(String lang) {
        langCaret.click();

        if(Objects.equals(lang, "Русский")){
            langRu.click();
        }
        else {
            langEn.click();
        }
    }

    public String getCurLang() {
        return curLang.getAttribute("title");
    }

    public String menuItems() {
        return topMenuUl.getText().replaceAll("\n", ", ");
    }

    public void selectCurrency(String currency) {
        currCaret.click();
        switch (currency){
            case ("EUR"):
                currEUR.click();
                break;
            case ("GBP"):
                currGBP.click();
                break;
            case ("USD"):
                currUSD.click();
                break;
            case ("RUB"):
                currRUB.click();
                break;
        }
    }

    public String getCurCurrency() {
        String currency = currCaret.getText().replaceAll("\\s.*", "");
        String curISO = "";
        switch (currency){
            case ("€"):
                curISO = "EUR";
                break;
            case ("£"):
                curISO = "GBP";
                break;
            case ("$"):
                curISO = "USD";
                break;
            case ("руб."):
                curISO = "RUB";
                break;
        }
        return curISO;
    }
}
