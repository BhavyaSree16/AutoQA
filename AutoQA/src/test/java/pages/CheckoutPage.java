package pages;

import org.openqa.selenium.*;
import utils.ConfigReader;

public class CheckoutPage extends BasePage {

    //Checkout buttons
    private By proceedCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By placeOrder = By.xpath("//a[contains(text(),'Place Order')]");

    // Payment fields
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");

    private By payBtn = By.id("submit");

    // Login redirect check
    private By loginPageText = By.xpath("//h2[contains(text(),'Login to your account')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Proceed to checkout
    public void clickProceedToCheckout() {
        waitForElement(proceedCheckout).click();
    }

    // Click Place Order
    public void clickPlaceOrder() {
        waitForElement(placeOrder).click();
    }

    // Enter payment details from config
    public void enterPaymentDetails() {

        waitForElement(nameOnCard).sendKeys(ConfigReader.get("nameOnCard"));
        waitForElement(cardNumber).sendKeys(ConfigReader.get("cardNumber"));
        waitForElement(cvc).sendKeys(ConfigReader.get("cvc"));
        waitForElement(expiryMonth).sendKeys(ConfigReader.get("expiryMonth"));
        waitForElement(expiryYear).sendKeys(ConfigReader.get("expiryYear"));

        System.out.println("✅ Payment details entered");
    }

    // Confirm Order
    public void confirmOrder() {
        waitForElement(payBtn).click();
        System.out.println("Order placed successfully");
    }

    // Verify redirect to login
    public boolean isRedirectedToLogin() {
        return waitForElement(loginPageText).isDisplayed();
    }
}