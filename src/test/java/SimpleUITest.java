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
import pages.BaiduHomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleUITest {

    private String phantomJSDriverPath = "Tools/Mac/phantomjs";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("phantomjs.binary.path", phantomJSDriverPath);
        driver = new PhantomJSDriver();
        wait = new WebDriverWait(driver, BaiduHomePage.TIME_OUT_IN_SECONDS);
    }

    @Test
    public void aWebTest() throws InterruptedException {
        driver.get(BaiduHomePage.testURL);
        driver.findElement(By.id(BaiduHomePage.SEARCH_TEXTBOX_ID)).sendKeys(BaiduHomePage.searchKeyword);
        driver.findElement(By.id(BaiduHomePage.SEARCH_BUTTON_ID)).click();
        wait.until(ExpectedConditions.titleContains(BaiduHomePage.searchKeyword));
        assertThat("Result page contains search keyword", driver.getTitle().contains(BaiduHomePage.searchKeyword));
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
