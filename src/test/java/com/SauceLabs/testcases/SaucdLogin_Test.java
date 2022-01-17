package com.SauceLabs.testcases;

import com.SauceLabs.pages.SauceLabs_Login;
import com.SauceLabs.utility.LogUtility;
import com.SauceLabs.utility.ReadConfig;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.SauceLabs.utility.LogUtility.*;

public class SaucdLogin_Test extends BaseClass{
    LogUtility logger = new LogUtility();
    ReadConfig readConfig = new ReadConfig();
    SauceLabs_Login s1;
    @Test
    public void LoginSauceLabs() throws IOException {
        extentTest = extent.createTest("Validate sauce labs Login");
        startTestCase("LoginSauceLabs");
        driver.get(readConfig.getApplicationURL());
        s1 = new SauceLabs_Login(driver);
        s1.setUsername();
        extentTest.info("username entered");
        info("username entered");
        s1.setPassword();
        extentTest.info("Password entered");
        info("Password entered");
        s1.clickLogin();
        extentTest.info("Login Button clicked");
        info("Login Button clicked");
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")){
            extentTest.pass("Login Successful");
            info("login successful");
            Assert.assertTrue(true);
        }else {
            extentTest.fail("Login Failed");
            error("login failed");
            Assert.assertTrue(false);
        }
    }
    @Test
    public void logout(){
        extentTest = extent.createTest("Validate sauce labs Logout");
        s1 = new SauceLabs_Login(driver);
        s1.clickMenu();
        extentTest.info("Profile Menu clicked");
        s1.CLickLogout();
        extentTest.info("Logout button clicked");
        if(driver.getCurrentUrl().equals(readConfig.getApplicationURL())){
            extentTest.pass("Logout Successful");
            info("Logout successful");
            Assert.assertTrue(true);

        }else{
            extentTest.fail("Logout Failed");
            error("Logout failed");
            //captureScreenshot(driver);
            Assert.assertTrue(false);
        }
    }
    }
