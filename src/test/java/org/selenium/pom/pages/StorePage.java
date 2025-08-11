package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By titlePage = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.className("checkout-button");


    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchField(String txt){
        driver.findElement(searchField).sendKeys(txt);
        return this;
    }

    public StorePage search(String txt){
        enterTextInSearchField(txt).clickSearchButton();
        return this;
    }

    private StorePage clickSearchButton(){
        driver.findElement(searchButton).click();
        return this;
    }

    public String getTitle(){
        return driver.findElement(titlePage).getText();
    }

    private By getAddToCartButtonElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
    }

    public StorePage clickAddToCartButton(String productName){
        By addToCartButton = getAddToCartButtonElement(productName);
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

}
