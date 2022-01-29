package com.SauceLabs.pages.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OPenMRS_dashboard {

    WebDriver driver;
    public OPenMRS_dashboard(WebDriver driver){
        this.driver=driver;
    }

    By homepageButton = By.xpath("//div[@class='logo']");
    By headingAdmin = By.xpath("//li[@class='nav-item identifier']");
    By adminPage = By.xpath("//a[@href='/openmrs/adminui/myaccount/myAccount.page']");
    By changesecTion = By.id("selected-location");

    By reagisterPatient = By.xpath("//a[contains(@id,'registerPatient')]");
    By SearchPatient = By.xpath("//i[@class='icon-search']");
    By ActiveVisits = By.xpath("//i[@class='icon-calendar']");
    By vitals= By.xpath("//i[@class='icon-vitals']");  //
    By Appointment= By.xpath("//i[@class='icon-calendar']");  //
    By Reports= By.xpath("//i[@class='icon-list-alt']");  //
    By DataManagement= By.xpath("//i[@class='icon-hdd']");  //
    By ConfigureMetadata= By.xpath("//i[@class='icon-tasks']");  //
    By SystemConfig= By.xpath("//i[@class='icon-cogs']");  //


    public void clickHomePageLogo(){
        driver.findElement(homepageButton).click();
    }
    public void MouseHover_HeadingAdmin(){
        WebElement menu = driver.findElement(headingAdmin);
//Creating object of an Actions class
        Actions action = new Actions(driver);
//Performing the mouse hover action on the target element.
        action.moveToElement(menu).perform();
        driver.findElement(adminPage).click();
    }
    public void CLickOnsearchPatient (){
        driver.findElement(SearchPatient).click();
    }
    public void setChangesecTion(){
        driver.findElement(changesecTion).click();
    }
    public void ClickReagisterPatient(){
        driver.findElement(reagisterPatient).click();
    }
}
