package com.SauceLabs.testcases.CLinicOpenMRS;

import com.SauceLabs.pages.openmrs.OPenMRS_dashboard;
import com.SauceLabs.pages.openmrs.RegisterPatient;
import com.SauceLabs.pages.openmrs.openmrsLogin;
import com.SauceLabs.testcases.BaseClass;
import com.SauceLabs.utility.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.SauceLabs.utility.LogUtility.info;

public class Test_Register_Patient extends BaseClass {


    ReadConfig readConfig = new ReadConfig();

    @Test
    public void ALogin() throws InterruptedException {
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
    public void BClickRegisterPatient() throws InterruptedException {
        op = new OPenMRS_dashboard(driver);
        op.ClickReagisterPatient();
        Thread.sleep(2000);
    }

    @Test
    public void XAddpatient(){

        rp = new RegisterPatient(driver);
        rp.setName();
        rp.setMiddlename();
        rp.setFamilyName();
        rp.clickNextButton();
        rp.SelectGender();
        rp.clickdropdown();
        rp.clickNextButton();
        rp.setDay();
        rp.ClickMonthDropdown();
        rp.setMonth();
        rp.setYear();
        rp.clickNextButton();
        rp.setAddress();
        rp.setCity();
        rp.setState();
        rp.setCountry();
        rp.setZipcode();
        rp.clickNextButton();
        rp.setpatientNumber();
        rp.setRelationType();
        rp.setrelationTypePerson();
        rp.submit();
    }


}
