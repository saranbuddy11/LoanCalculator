package stepDefinitions;

import base.FunctionalLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import uiObjectRepository.LoanPage;
import utilsBrowser.browserSetting.*;
import utilsBrowser.configuration.ConfigarationProvider;
import utilsBrowser.configuration.Configuration;

import java.util.HashMap;
import java.util.Map;

import static javax.security.auth.login.Configuration.getConfiguration;

public abstract class AbstractTest {
    private static final Log logger = LogFactory.getLog(FunctionalLibrary.class);

    public static final String environment = getEnvironment();
    private static final String browser = getBrowser();
    protected WebDriver driver;

    protected static ConfigarationProvider configarationProvider = new ConfigarationProvider();
    protected Configuration configuration = configarationProvider.getConfiguration(environment);

    protected FunctionalLibrary functionalLibrary;
    protected LoanPage loanPage;

    public WebDriver getDriver() {
        return driver;
    }

    private static String getEnvironment() {
        return System.getProperty("environment");
    }

    private void getBrowser(Map<String, BrowserSettings> props) {
        driver = BrowserFactory.getBrowser(props);
    }

    private BrowserSettings getBrowserSettings() {
        BrowserSettings browserSettings;
        switch (browser) {
            case "chrome":
                browserSettings = new ChromeSettings();
                break;
            default:
                browserSettings = new ChromeSettings();
        }
        return browserSettings;
    }

    public void setUp() {
        BrowserSettings browserSettings = getBrowserSettings();
        setUp(new HashMap<String, BrowserSettings>() {{
            put(browser, browserSettings);
        }});
    }

    public void setUp(Map<String, BrowserSettings> props) {
        getBrowser(props);
        getConfiguration();
        openBrowser();
        maximizeBrowser();
        initializePage();
    }

    void initializePage() {
        functionalLibrary = new FunctionalLibrary(driver);
        loanPage = new LoanPage(driver);
    }

    private void openBrowser() {
        driver.get(configuration.getUrl());
    }

    private static String getBrowser() {
        return System.getProperty("browser");
    }

    private void maximizeBrowser() {
        maximize();
        logger.info("Browser resolution is: " + getSize());
    }

    private Dimension getSize() {
        return driver.manage().window().getSize();
    }

    private void maximize() {
        driver.manage().window().maximize();
        logger.info("Current window maximized");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
