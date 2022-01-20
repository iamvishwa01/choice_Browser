package com.SauceLabs.pages.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatient {

    WebDriver driver;
    public RegisterPatient(WebDriver driver){
        this.driver=driver;
    }
    By name = By.name("givenName");
    By middlename = By.name("middleName");
    By familyName = By.name("familyName");
    By nextButton = By.id("next-button");
    By genderdropdown = By.id("gender-field");
    By day = By.id("birthdateDay-field");
    By monthDropdown = By.id("birthdateMonth-field");
    By year = By.id("birthdateYear-field");
    By address = By.id("address1");
    By address1 = By.id("address2");
    By city = By.id("cityVillage");
    By state = By.id("stateProvince");
    By country = By.id("country");
    By zipcode = By.id("postalCode");
    By patientNumber = By.id("phoneNumber");
    By relationTypeSelect = By.id("relationship_type");
    By relationTypePerson = By.xpath("//*[@ng-model='relationship.name']");
    By cancelRegistration = By.id("cancelSubmission");
    By submit = By.id("submit");

    public void setName(){
        driver.findElement(name).sendKeys("test");
    }
    public void setMiddlename(){
        driver.findElement(middlename).sendKeys("test");
    }
    public void setFamilyName(){
        driver.findElement(familyName).sendKeys("test");
    }
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    public void clickdropdown(){
        driver.findElement(genderdropdown).click();
    }
    public void SelectGender(){
        Select gender = new Select(driver.findElement(genderdropdown));

        gender.selectByIndex(0);
    }


    public void setDay(){
        driver.findElement(day).sendKeys("12");
    }
    public void ClickMonthDropdown(){
        driver.findElement(monthDropdown).click();
    }
    public void setMonth(){
       Select Month = new Select( driver.findElement(monthDropdown));
       Month.selectByIndex(4);
    }
    public void setYear(){
        driver.findElement(year).sendKeys("2000");
    }
    public void setAddress(){
        driver.findElement(address).sendKeys("india");
        driver.findElement(address1).sendKeys("test");
    }
    public void setCity(){
        driver.findElement(city).sendKeys("test");
    }
    public void setState(){
        driver.findElement(state).sendKeys("test");
    }
    public void setCountry(){
        driver.findElement(country).sendKeys("test");
    }
    public void setZipcode(){
        driver.findElement(zipcode).sendKeys("123123");
    }
    public void setpatientNumber(){
        driver.findElement(patientNumber).sendKeys("78454589");
    }
    public void setRelationType(){
        Select relationtype = new Select(driver.findElement(relationTypeSelect));
        relationtype.deselectByValue("Parent");
    }
    public void setrelationTypePerson(){
        driver.findElement(relationTypePerson).sendKeys("test");
    }
    public void cancelRegistration(){
        driver.findElement(cancelRegistration).click();
    }
    public void submit(){
        driver.findElement(submit).click();
    }
}
