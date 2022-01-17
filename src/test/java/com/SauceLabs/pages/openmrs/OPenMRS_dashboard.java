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

    public void setChangesecTion(){
        driver.findElement(changesecTion).click();
    }
    public void setReagisterPatient(){
        driver.findElement(reagisterPatient).click();
    }
}
