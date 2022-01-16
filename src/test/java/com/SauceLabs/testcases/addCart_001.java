package com.SauceLabs.testcases;

import com.SauceLabs.pages.SauceLabs_Login;
import com.SauceLabs.pages.addCartPageObj;
import com.SauceLabs.utility.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.SauceLabs.utility.LogUtility.*;


public class addCart_001 extends BaseClass{
    ReadConfig readConfig = new ReadConfig();
    SauceLabs_Login s1;
    @Test
    public void LoginSauceLabs() throws IOException {
        extentTest = extent.createTest("Validate sauce labs Login");
        s1 = new SauceLabs_Login(driver);
        s1.setUsername();
        s1.setPassword();
        s1.clickLogin();
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
    public void addCart() throws IOException, InterruptedException {
        extentTest = extent.createTest("addCart from sauce labs");
        addCartPageObj ad = new addCartPageObj(driver);
        ad.addtoCart();
        ad.clickoncart();
        info("clicked on cart");
        ad.checkout();
        info("clicked on checkout button");
        ad.fname("test");
        ad.lname("lname");
        ad.zipcode("123123");
        info("fname,lname and postal code provided");
        ad.placeorder();
        info("placing order");
        ad.Finishorder();
        info("order placed");
        ad.verifyorder();
       info("Verifying order");
        String vali = ad.verifyorder();
        if(vali.contains("THANK YOU FOR YOUR ORDER")) {
            info("order place successfully");
            ad.BackToHome();
            Assert.assertTrue(true);

        }else {
            error("Error in placing order");
        }
    }
    @Test
    public void logout(){
        extentTest = extent.createTest("Logout from sauce labs");
        s1 = new SauceLabs_Login(driver);
        s1.clickMenu();
        s1.CLickLogout();
        if(driver.getCurrentUrl().equals(readConfig.getApplicationURL())){
            info("logged out successfully");
            extentTest.info("logged out successfully");
            Assert.assertTrue(true);
        }else{
            error("Error in logout");
            extentTest.info("Error in logout");
            Assert.assertTrue(false);
        }
    }
}
