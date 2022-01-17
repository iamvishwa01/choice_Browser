package com.SauceLabs.utility;
import com.SauceLabs.testcases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.IOException;
import static com.SauceLabs.testcases.BaseClass.formatdate;

public class Reporting extends TestListenerAdapter {
    public ExtentReports extent = new ExtentReports();
    public ExtentTest extentTest;
    public void onStart(ITestContext testContext) {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/TestReport_" + formatdate() + ".html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("HRM Application");
        extent.setSystemInfo("Company Name", "Test");
        extent.setSystemInfo("Application", "HRM");
        extent.setSystemInfo("Project", "HRM");
        extent.setSystemInfo("Tester", "Sujeet Vishwakarma");
        extent.setSystemInfo("Environment", "QA");
        extent.attachReporter(spark);
    }
    public void onTestSuccess(ITestResult tr) {
        extentTest = extent.createTest(tr.getName()); // create new entry in th report
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+" "+"Test is Passed", ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
    }
    public void onTestFailure(ITestResult tr) {
        extentTest = extent.createTest(tr.getName(),"test"); // create new entry in th report
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName()+" "+"Test is Failed", ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
        extentTest.log(Status.FAIL, tr.getName() + " " + "Test Case Failed !!");
        extentTest.log(Status.FAIL, tr.getThrowable() + " " + "Test Case Failed !!");
        String screenshotPath = null;
        try {
            screenshotPath = BaseClass.captureScreenshot(BaseClass.driver, tr.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.fail("Failed TestCase Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }



    public void onTestSkipped(ITestResult tr) {
        extentTest = extent.createTest(tr.getName()); // create new entry in th report
        extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName()+" "+"Test is Skipped", ExtentColor.GREY));
    }



    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}