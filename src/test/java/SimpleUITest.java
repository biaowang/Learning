import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleUITest {

    private String phantomJSDriverPath = "Tools/Mac/phantomjs";

    private static final long TIME_OUT_IN_SECONDS = 10;
    private WebDriver driver;
    private WebDriverWait wait;
    private String testURL = "https://www.baidu.com/";
    private String SEARCH_TEXTBOX_ID = "kw";
    private String searchKeyword = "test";
    private String SEARCH_BUTTON_ID = "su";

    @BeforeClass
    public void setUp() {
        System.setProperty("phantomjs.binary.path", phantomJSDriverPath);
        driver = new PhantomJSDriver();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    }

    @Test
    public void aWebTest() throws InterruptedException {
        driver.get(testURL);
        driver.findElement(By.id(SEARCH_TEXTBOX_ID)).sendKeys(searchKeyword);
        driver.findElement(By.id(SEARCH_BUTTON_ID)).click();
        wait.until(ExpectedConditions.titleContains(searchKeyword));
        assertThat("Result page contains search keyword", driver.getTitle().contains(searchKeyword));
    }


    private Function<WebDriver, Boolean> isPageLoaded() {
        return new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        };
    }

    private void waitForPageLoad() {
        wait.until(isPageLoaded());
    }

    @AfterClass
    private void clean() {
        driver.close();
    }

}
