package com.SauceLabs.testcases;


import com.SauceLabs.pages.openmrs.OPenMRS_dashboard;
import com.SauceLabs.pages.openmrs.RegisterPatient;
import com.SauceLabs.pages.openmrs.findPatient;
import com.SauceLabs.pages.openmrs.openmrsLogin;
import com.SauceLabs.utility.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
import static com.SauceLabs.utility.LogUtility.info;


public class BaseClass {

    public static Logger logger;
   public static WebDriver driver;
    ReadConfig readConfig = new ReadConfig();
   public ExtentReports extent = new ExtentReports();
   public ExtentTest extentTest;
    public OPenMRS_dashboard op;
    public openmrsLogin o1;
    public RegisterPatient rp;
    public findPatient fp;
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
        startTestCase("Starting the test");
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getCdriver());
            driver = new ChromeDriver();
            info("Chrome browser launched");
            driver.manage().window().maximize();
            info("Browser Maximized");
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFdriver());
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            driver = new FirefoxDriver(options);
            info("Firefox browser launched");
            driver.manage().window().maximize();
            info("Browser Maximized");

        }else  if(br.equals("Edge")){
            System.setProperty("webdriver.edge.driver",readConfig.getEdgeDriver());
            driver = new EdgeDriver();
            info("Microsoft browser launched");
            driver.manage().window().maximize();
            info("Browser Maximized");
        }else if(br.equals("IE_Browser")){
//            System.setProperty("webdriver.ie.driver",readConfig.getIEdriver());
//            driver=new InternetExplorerDriver();
//            info("Internet Explorer browser launched");
//            driver.manage().window().maximize();
//            info("Browser Maximized");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            System.setProperty("webdriver.ie.driver",readConfig.getIEdriver());
            driver = new InternetExplorerDriver(capabilities);
            driver.manage().window().maximize();
            info("Browser Maximized");
        }
        else {
            info("Please select a browser or provide a browser");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    }
    @AfterClass
        public void Teardown(){
        driver.quit();
        endTestCase("Test done !");
    }


}
