package tests;

import common.WebBrowser;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BaiduHomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleUITest extends WebBrowser {

    private BaiduHomePage baiduHomePage;

    @BeforeClass
    public void setUp() {
        baiduHomePage = PageFactory.initElements(driver, BaiduHomePage.class);
    }

    @Test
    public void aWebTest() throws InterruptedException {
        driver.get(BaiduHomePage.URL);
        baiduHomePage.TypeSearchKeyWord(driver, BaiduHomePage.searchKeyword);
        baiduHomePage.clickSearch(driver);
        wait.until(ExpectedConditions.titleContains(BaiduHomePage.searchKeyword));
        assertThat("Result page not contains search keyword", driver.getTitle().contains(BaiduHomePage.searchKeyword));
    }


    @AfterClass
    private void clean() {
        driver.close();
    }

}
