package com.SauceLabs.testcases.CLinicOpenMRS;

import com.SauceLabs.pages.openmrs.OPenMRS_dashboard;
import com.SauceLabs.pages.openmrs.RegisterPatient;
import com.SauceLabs.pages.openmrs.openmrsLogin;
import com.SauceLabs.testcases.BaseClass;
import com.SauceLabs.utility.LogUtility;
import com.SauceLabs.utility.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.SauceLabs.utility.LogUtility.info;
import static com.SauceLabs.utility.LogUtility.warn;

public class Test_OpenMRS_Login extends BaseClass {

    ReadConfig readConfig = new ReadConfig();
openmrsLogin o1;


    @Test(groups = "smoke")

public void A_ValidateTitle(){

    driver.get(readConfig.getclinicURL());
    if(driver.getTitle().equals("Login")){
        info("Title Matched");
        Assert.assertTrue(true);

    }else {
        info("Title not matched");
        Assert.assertTrue(false);

    }
}

    @Test(groups = "smoke")
    public void B_LoginToOpenMRS(){
        driver.get(readConfig.getclinicURL());
        info("Loading application URL");
        o1 = new openmrsLogin(driver);
        o1.setUsername();
        o1.setPassword();
        o1.selectWard();
        o1.CLicklogin();
        if(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/referenceapplication/home.page")){
            info("Login success");
            Assert.assertTrue(true);

        }else{
            info("Login failed");
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

//    @Test
//    public void Logout(){
//
//        o1 = new openmrsLogin(driver);
//        o1.Logout();
//        if(driver.getTitle().equals("Login")){
//            info("Logged out successfully");
//            Assert.assertTrue(true);
//        }else{
//            info("Error in Logout");
//            Assert.assertTrue(false);
//        }
//    }
}
