package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField =  By.id("billing_last_name");
    private final By addressLineOneField = By.id("billing_address_1");
    private final By billingCityField = By.id("billing_city");
    private final By billingPostCodeField = By.id("billing_postcode");
    private final By billingEmailField = By.id("billing_email");
    private final By placeOrderButton = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By loginButton = By.className("showlogin");

    private final By userNameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton2 = By.name("login");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName){
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLine(String addressLine){
        driver.findElement(addressLineOneField).clear();
        driver.findElement(addressLineOneField).sendKeys(addressLine);
        return this;
    }

    public CheckoutPage enterBillingCity(String city){
        driver.findElement(billingCityField).clear();
        driver.findElement(billingCityField).sendKeys(city);
        return this;
    }

    public CheckoutPage enterBillingPostCode(String postCode){
        driver.findElement(billingPostCodeField).clear();
        driver.findElement(billingPostCodeField).sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterBillingEmail(String email){
        driver.findElement(billingEmailField).clear();
        driver.findElement(billingEmailField).sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLine(billingAddress.getAddressLineOne()).
                enterBillingCity(billingAddress.getCity()).
                enterBillingPostCode(billingAddress.getPostalCode()).
                enterBillingEmail(billingAddress.getEmail());
        return this;
    }

    public CheckoutPage clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        return this;
    }

    public String getNoticeMessage(){
        return driver.findElement(successNotice).getText();
    }



    public CheckoutPage logUser(String username, String password) throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton2).click();
        return this;
    }

}
