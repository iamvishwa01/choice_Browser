package com.SauceLabs.testcases;


import com.SauceLabs.pages.openmrs.OPenMRS_dashboard;
import com.SauceLabs.pages.openmrs.RegisterPatient;
import com.SauceLabs.pages.openmrs.openmrsLogin;
import com.SauceLabs.utility.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.SauceLabs.utility.LogUtility.*;


public class BaseClass {

    public static Logger logger;
   public static WebDriver driver;
    ReadConfig readConfig = new ReadConfig();
    ExtentReports extent = new ExtentReports();
    ExtentTest extentTest;
    public OPenMRS_dashboard op;
    public openmrsLogin o1;
    public RegisterPatient rp;
    public static String captureScreenshot(WebDriver driver,String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public static String formatdate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    @Parameters(value = "browser")
    @BeforeClass
    public void setup(String br) {
//        logger = Logger.getLogger("swaglabs");
//        PropertyConfigurator.configure(System.getProperty("user.dir")+"/configuration/log4j.properties");
        startTestCase("Starting the test");
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getCdriver());
            driver = new ChromeDriver();
            info("Chrome browser launched");
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFdriver());
            driver = new FirefoxDriver();
            logger.info("Firefox browser launched");
        } else {
            info("Please select a browser or provide a browser");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       info("Browser Maximized");
//        driver.get(readConfig.getApplicationURL());
//        info("Loading application URL");
    }
    @AfterClass
        public void Teardown(){
        driver.quit();
        endTestCase("Test done !");
    }


}
