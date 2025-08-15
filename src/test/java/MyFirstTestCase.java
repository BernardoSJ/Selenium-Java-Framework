import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton(product.getName());
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckoutPage checkoutPage = cartPage.
                checkout().
                setBillingAddress(billingAddress).
                clickPlaceOrderButton();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNoticeMessage(), "Thank you. Your order has been received.");

    }

    @Test
    public void loginAndGuestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();


        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.
                logUser("demouserbsj", "demo").
                enterFirstName("demo").
                enterLastName("user").
                enterAddressLine("San Francisco").
                enterBillingCity("San Francisco").
                enterBillingPostCode("94188").
                enterBillingEmail("askomdch@gmail.com").
                clickPlaceOrderButton();

        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNoticeMessage(), "Thank you. Your order has been received.");

    }
}
