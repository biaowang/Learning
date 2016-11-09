package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiduHomePage {

    public static String URL = "https://www.baidu.com/";
    public static String searchKeyword = "test";

    private static final String SEARCH_BUTTON_ID = "su";
    private static final String SEARCH_TEXTBOX_ID = "kw";

    @FindBy(id = SEARCH_BUTTON_ID)
    private static WebElement search_button;

    @FindBy(id = SEARCH_TEXTBOX_ID)
    private static WebElement search_textbox;


    public void TypeSearchKeyWord(WebDriver driver, String searchKeyword) {
        search_textbox.sendKeys(searchKeyword);
    }

    public void clickSearch(WebDriver driver) {
        search_button.click();
    }
}
