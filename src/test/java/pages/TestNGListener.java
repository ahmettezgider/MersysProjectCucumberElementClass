package pages;


import org.testng.*;

public class TestNGListener implements ITestListener, ISuiteListener, IClassListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Listener : onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Listener : onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Listener : onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Listener : onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test Listener : onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test Listener : onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test Listener : onFinish");
    }

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Suite Listener : onStart");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Suite Listener : onFinish");
    }

    @Override
    public void onBeforeClass(ITestClass iTestClass) {
        System.out.println("Class Listener : onBeforeClass");
    }

    @Override
    public void onAfterClass(ITestClass iTestClass) {
        System.out.println("Class Listener : onAfterClass");
    }
}
