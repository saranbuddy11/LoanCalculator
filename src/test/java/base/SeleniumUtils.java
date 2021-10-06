package base;


import org.openqa.selenium.WebElement;

public interface SeleniumUtils {

    String getPageUrl();

    void refresh();

    String getBaseURL();

    boolean isAt(String pageUrl);

    public void waitInSec(Integer sec);

    void moveToElementAndForceClick(WebElement element);

    public void scrollIntoView(WebElement element);

}
