package com.SauceLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addCartPageObj {
    WebDriver ldriver;
    public addCartPageObj (WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // find add to cart
    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-backpack']")
    @CacheLookup
    WebElement addtocart;

    @FindBy(how = How.XPATH, using = "//div[@class='shopping_cart_container']")
    @CacheLookup
    WebElement clickoncart;

    @FindBy(how = How.XPATH, using = "//button[@id='checkout']")
    @CacheLookup
    WebElement Checkout;

    @FindBy(how = How.XPATH, using = "//input[@id='first-name']")
    @CacheLookup
    WebElement FirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='last-name']")
    @CacheLookup
    WebElement LastName;

    @FindBy(how = How.XPATH, using = "//input[@id='postal-code']")
    @CacheLookup
    WebElement PostalCode;

    @FindBy(how = How.XPATH, using = "//input[@id='continue']")
    @CacheLookup
    WebElement PlaceOrder;

    @FindBy(how = How.XPATH, using = "//button[@id='finish']")
    @CacheLookup
    WebElement Finishorder;

    @FindBy(how = How.XPATH, using = "//h2[@class='complete-header']")
    @CacheLookup
    WebElement verifyorder;

    @FindBy(how = How.XPATH, using = "//button[@id='back-to-products']")
    @CacheLookup
    WebElement BackTohome;

    public void addtoCart() {
        addtocart.click();
    }
    public void clickoncart() {
        clickoncart.click();
    }

    public void checkout() {
        Checkout.click();
    }

    public void fname(String fname) {
        FirstName.sendKeys(fname);
    }

    public void lname(String lname) {
        LastName.sendKeys(lname);
    }

    public void zipcode(String zip) {
        PostalCode.sendKeys(zip);
    }

    public void placeorder() {
        PlaceOrder.click();
    }

    public void Finishorder() {
        Finishorder.click();
    }

    public  String verifyorder() {
        return verifyorder.getText();
    }

    public void BackToHome() {
        BackTohome.click();
    }
}
