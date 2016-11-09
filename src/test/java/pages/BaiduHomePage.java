package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaiduHomePage {

    public static final long TIME_OUT_IN_SECONDS = 10;
    public static String URL = "https://www.baidu.com/";
    public static String searchKeyword = "test";

    private static String SEARCH_BUTTON_ID = "su";
    private static String SEARCH_TEXTBOX_ID = "kw";

    public static void TypeSearchKeyWord(WebDriver driver, String searchKeyword) {
        driver.findElement(By.id(SEARCH_TEXTBOX_ID)).sendKeys(searchKeyword);
    }

    public static void clickSearch(WebDriver driver) {
        driver.findElement(By.id(SEARCH_BUTTON_ID)).click();
    }
}
