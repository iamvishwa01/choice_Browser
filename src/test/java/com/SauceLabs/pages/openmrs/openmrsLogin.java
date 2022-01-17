package com.SauceLabs.pages.openmrs;

import com.SauceLabs.testcases.BaseClass;
import com.SauceLabs.utility.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.SauceLabs.utility.LogUtility.info;

public class openmrsLogin extends BaseClass {


    WebDriver driver ;
ReadConfig readConfig = new ReadConfig();
    public openmrsLogin(WebDriver driver){
        this.driver=driver;
    }

    By username = By.id("username");
    By password = By.id("password");
    By patientWard = By.xpath("//li[contains(text(),'Inpatient Ward')]");
    By login = By.id("loginButton");
    By Logout = By.xpath("//*[@href='/openmrs/appui/header/logout.action?successUrl=openmrs']");


    public void setUsername(){
        driver.findElement(username).sendKeys(readConfig.getClinicUsername());
    }
    public void setPassword(){
        driver.findElement(password).sendKeys(readConfig.getClinicpassword());
    }
    public void selectWard(){
        driver.findElement(patientWard).click();
    }
    public void CLicklogin(){
        driver.findElement(login).click();
    }
    public void CLickLogout(){driver.findElement(Logout).click();}



}
