package pages;

import org.openqa.selenium.*;
import utils.ConfigReader;

public class CheckoutPage extends BasePage {

    private By proceedCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By placeOrder = By.xpath("//a[contains(text(),'Place Order')]");

    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");

    private By payBtn = By.id("submit");

    // 🔥 Login redirect check
    private By loginText = By.xpath("//h2[contains(text(),'Login to your account')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // ✅ MATCHING METHOD NAME
    public void clickProceedToCheckout() {
        waitForElement(proceedCheckout).click();
    }

    public void clickPlaceOrder() {
        waitForElement(placeOrder).click();
    }

    public void enterPaymentDetails() {

        waitForElement(nameOnCard).sendKeys(ConfigReader.get("nameOnCard"));
        waitForElement(cardNumber).sendKeys(ConfigReader.get("cardNumber"));
        waitForElement(cvc).sendKeys(ConfigReader.get("cvc"));
        waitForElement(expiryMonth).sendKeys(ConfigReader.get("expiryMonth"));
        waitForElement(expiryYear).sendKeys(ConfigReader.get("expiryYear"));

        System.out.println("Payment details entered");
    }

    public void confirmOrder() {
        waitForElement(payBtn).click();
        System.out.println("Order confirmed");
    }

    // ✅ ADD THIS METHOD
    public boolean isRedirectedToLogin() {
        return waitForElement(loginText).isDisplayed();
    }
}