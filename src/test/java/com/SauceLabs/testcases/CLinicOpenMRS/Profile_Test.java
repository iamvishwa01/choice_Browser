package com.SauceLabs.testcases.CLinicOpenMRS;

import com.SauceLabs.pages.openmrs.OPenMRS_dashboard;
import com.SauceLabs.pages.openmrs.openmrsLogin;
import com.SauceLabs.testcases.BaseClass;
import com.SauceLabs.utility.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.SauceLabs.utility.LogUtility.info;
import static com.SauceLabs.utility.LogUtility.startTestCase;

public class Profile_Test extends BaseClass {

    ReadConfig readConfig = new ReadConfig();
    @Test
    public void ALogin() throws InterruptedException {
        startTestCase("Admin Profile");
        driver.get(readConfig.getclinicURL());
        o1 = new openmrsLogin(driver);
        o1.setUsername();
        o1.setPassword();
        o1.selectWard();
        o1.CLicklogin();
        if(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/referenceapplication/home.page")){
            info("Login success");
            Assert.assertTrue(true);
            Thread.sleep(5000);
        }else{
            info("Login failed");
            Assert.assertTrue(false);

        }

    }

    @Test
    public void BtestProfile() throws InterruptedException {
        op = new OPenMRS_dashboard(driver);
op.MouseHover_HeadingAdmin();
if(driver.getPageSource().contains("My Account")){
    info("On Profile Page");
    Assert.assertTrue(true);
    Thread.sleep(2000);
}else{
    info("unable to load profile page");
    Assert.assertTrue(false);
}
    }

    @Test
    public void C_Logout(){
        o1 = new openmrsLogin(driver);
        o1.CLickLogout();
        if(driver.getTitle().equals("Login")){
            info("Logout success");
            Assert.assertTrue(true);
        }else{
            info("logout failed");
            Assert.assertTrue(false);
        }
    }

}
