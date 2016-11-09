package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestUtils {

    private static String screenshotFilePath = "target\\surefire-reports\\screenshots";

    public static void takeScreenshot(String fileName) {

        WebDriver driver = WebBrowser.driver;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(screenshotFilePath + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
