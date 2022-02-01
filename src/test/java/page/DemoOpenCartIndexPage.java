package page;

import service.MyWebDriver;

public class DemoOpenCartIndexPage extends DemoOpenCartDefault {

    public DemoOpenCartIndexPage(MyWebDriver driver) {
        super(driver, DemoOpenCartDefault.config.getIndexPageURL());
    }
}
