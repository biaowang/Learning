package Utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        System.out.println("Test Starts ... ...");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("Test Failed: " + tr.getTestName());
    }
}
