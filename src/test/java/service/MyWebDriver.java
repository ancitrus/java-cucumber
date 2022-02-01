package service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MyWebDriver {
    private final WebDriver driver;

    public MyWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver = driver;
    }

    public void getUrl(String url){
        this.driver.get(url);
    }

    public void initElements(PageFactory page){
        PageFactory.initElements(this.driver, page);
    }

    public void tearDown(){
        this.driver.close();
        this.driver.quit();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
