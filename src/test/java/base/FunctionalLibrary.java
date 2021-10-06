package base;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class FunctionalLibrary implements SeleniumUtils {

    private static final Log logger = LogFactory.getLog(FunctionalLibrary.class);

    private static final String BASE_URL = "";

    public static WebDriver driver;
    protected Actions action;

    public JavascriptExecutor jsExecutor;

    public FunctionalLibrary(WebDriver driver) {
        action = new Actions(driver);
        PageFactory.initElements(getElementLocatorFactory(driver), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver getElementLocatorFactory(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        return driver;
    }

    public <G extends FunctionalLibrary, T extends AbstractAssertion<G>> T startAssertions(Class<T> clazz) throws RuntimeException {
        try {
            AbstractAssertion<G> assertion = clazz.newInstance();
            assertion.setPage((G) this);
            return (T) assertion;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error occured during creating Assertions. ", e);
        }
    }

    @Override
    public void refresh() {
        logger.info("Refresh page");
        driver.navigate().refresh();
    }

    @Override
    public String getPageUrl() {
        logger.info(": Getting current URL.");
        return driver.getCurrentUrl();
    }

    @Override
    public void waitInSec(Integer sec) {
        logger.info(": waiting for " + sec + " with thread sleep for 1 sec");
        long milisec = sec.longValue() * 1000;
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveToElementAndForceClick(WebElement element) {
        logger.info(": move to element actions");
        action.moveToElement(element).click().build().perform();
    }

    @Override
    public void scrollIntoView(WebElement element) {
        logger.info(": scroll to element using java script executor");
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public boolean isAt(String pageUrl) {
        logger.info(": method start");
        String actualUrl = getPageUrl();
        logger.info("Page Class: expected base url: " + pageUrl);
        logger.info("Page Class: actual url: " + actualUrl);
        return actualUrl.contains(pageUrl);
    }

    @Override
    public String getBaseURL() {
        logger.info(": method start");
        return BASE_URL;
    }
}