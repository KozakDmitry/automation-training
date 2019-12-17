package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 15;
    private static final Logger LOGGER = LogManager.getRootLogger();

    protected WebDriver webDriver;
    protected abstract AbstractPage openPage();


    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getCurrentUrl() { return webDriver.getCurrentUrl(); }
}