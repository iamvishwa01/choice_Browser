package com.SauceLabs.pages.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class findPatient {

    WebDriver driver;
    public findPatient(WebDriver driver){
       this.driver=driver;
    }

    By headingofthePage = By.xpath("//h2[contains(text(),'Find Patient Record')]");
    By searchBox = By.id("patient-search");
    By PatientName = By.xpath("//table/tbody/tr/td[2]");
    By PatientGender = By.xpath("//table/tbody/tr/td[3]");
    By PatientAge = By.xpath("//table/tbody/tr/td[4]");

    public String ValidateHading(){
      String heading = driver.findElement(headingofthePage).getText();
        return heading;
    }
    public void searchPatient(){
        driver.findElement(searchBox).sendKeys("100KH7");
    }
    public String checkPatientName(){
      String name =  driver.findElement(PatientName).getText();
        return name;
    }
    public String checkPatientGender(){
       String gender= driver.findElement(PatientGender).getText();
        return gender;
    }
public String checkAge(){
        String age =driver.findElement(PatientAge).getText();
        return age;
}
}
