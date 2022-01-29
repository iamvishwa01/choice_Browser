package com.SauceLabs.testcases.CLinicOpenMRS;

import com.SauceLabs.pages.openmrs.OPenMRS_dashboard;
import com.SauceLabs.pages.openmrs.findPatient;
import com.SauceLabs.pages.openmrs.openmrsLogin;
import com.SauceLabs.testcases.BaseClass;
import com.SauceLabs.utility.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.SauceLabs.utility.LogUtility.info;
import static com.SauceLabs.utility.LogUtility.startTestCase;

public class Test_FindPatients extends BaseClass {
    ReadConfig readConfig = new ReadConfig();
    @Test
    public void ALogin() throws InterruptedException {
        startTestCase("Search Patient");
        driver.get(readConfig.getclinicURL());
        o1 = new openmrsLogin(driver);
        o1.setUsername();
        o1.setPassword();
        o1.selectWard();
        o1.CLicklogin();
        if(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/referenceapplication/home.page")){
            info("Login success");
            Assert.assertTrue(true);
            Thread.sleep(3000);

        }else{
            info("Login failed");
            Assert.assertTrue(false);
        }

    }
@Test
public void B_clickfindpatient() throws InterruptedException {
    op = new OPenMRS_dashboard(driver);
    op.CLickOnsearchPatient();
    Thread.sleep(2000);
}
@Test
    public void C_SearchPatient(){
    fp = new findPatient(driver);

if(driver.getTitle().equals("OpenMRS Electronic Medical Record")){
    info("On patient search page");
    Assert.assertTrue(true);
    System.out.println(fp.ValidateHading());
    System.out.println(fp.checkAge());
    System.out.println(fp.checkPatientName());
    System.out.println(fp.checkPatientGender());
    if(fp.ValidateHading().equals("Find Patient Record")){
        info("search page displayed properly");
        Assert.assertTrue(true);
        fp.searchPatient();
        if(fp.checkPatientName().equals("Dev User")){
            info("Name Present");
        }else{
            info("Name not Present");
        }
    }else{
        info("error in displaying search patient page");
        Assert.assertTrue(true);
    }


   }else
   {
       info("Failed to redirect to search patient page");
       Assert.assertTrue(false);
   }
}


}
