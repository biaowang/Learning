import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleUITest {

    private static final long TIME_OUT_IN_SECONDS = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void aWebTest() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver", "Tools/Mac/chromedriver");
        System.setProperty("phantomjs.binary.path", "Tools/Mac/phantomjs");

//        driver = new ChromeDriver();
        driver = new PhantomJSDriver();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("test");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("su")).click();
        waitForPageLoad();
        wait.until(ExpectedConditions.titleContains("test"));
        System.out.println(driver.getTitle());
        assertThat("Result page contains search keyword", driver.getTitle().contains("test"));
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
