package common;

import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class WebBrowser {

    private static final int TIME_OUT_IN_SECONDS = 15;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static String phantomJSDriverPath = "Tools/Mac/phantomjs";

    @BeforeSuite
    public void setup() {
        System.setProperty("phantomjs.binary.path", WebBrowser.phantomJSDriverPath);
        driver = buildWebDriver();
        wait = new WebDriverWait(WebBrowser.driver, WebBrowser.TIME_OUT_IN_SECONDS);
    }

    private WebDriver buildWebDriver() {
        return new PhantomJSDriver();
    }

    private Function<WebDriver, Boolean> isPageLoaded() {
        return new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        };
    }

    public void waitForPageLoad() {
        wait.until(isPageLoaded());
    }


}
